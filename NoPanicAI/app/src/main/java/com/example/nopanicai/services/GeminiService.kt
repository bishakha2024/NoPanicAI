package com.example.nopanicai.services

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL

const val GEMINI_API_KEY = "ADD_YOUR_API_KEY_HERE"

suspend fun generateGeminiSummary(notes: String): String {

    return withContext(Dispatchers.IO) {

        try {

            val url = URL(
                "https://generativelanguage.googleapis.com/v1beta/models/gemini-flash-latest:generateContent?key=$GEMINI_API_KEY"
            )

            val connection = url.openConnection() as HttpURLConnection

            connection.requestMethod = "POST"
            connection.setRequestProperty("Content-Type", "application/json")
            connection.doOutput = true

            val prompt =
                "Summarize shortly in 3 bullet points:\n$notes"

            val requestBody = """
                {
                  "contents": [
                    {
                      "parts": [
                        {
                          "text": "$prompt"
                        }
                      ]
                    }
                  ]
                }
            """.trimIndent()

            connection.outputStream.use {
                it.write(requestBody.toByteArray())
            }

            val responseCode = connection.responseCode

            val responseText =
                if (responseCode in 200..299) {
                    connection.inputStream.bufferedReader().readText()
                } else {
                    connection.errorStream.bufferedReader().readText()
                }

            if (responseCode == 429) {
                return@withContext "AI is busy. Please wait 1 minute and try again."
            }

            if (responseCode !in 200..299) {
                return@withContext "AI summary failed. Please try again."
            }

            val json = JSONObject(responseText)

            json.getJSONArray("candidates")
                .getJSONObject(0)
                .getJSONObject("content")
                .getJSONArray("parts")
                .getJSONObject(0)
                .getString("text")

        } catch (e: Exception) {

            "AI summary failed."
        }
    }
}