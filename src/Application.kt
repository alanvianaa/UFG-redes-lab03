package com.alanviana

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond
import io.ktor.response.respondFile
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.netty.EngineMain
import java.io.File

fun main(args: Array<String>): Unit = EngineMain.main(args)

fun Application.module() {

    routing {
        get("/{name}") {
            File("resources/static/${call.parameters["name"]}.png").let {
                if (it.exists()) call.respondFile(it) else call.respond(HttpStatusCode.NotFound)
            }
        }
    }
}