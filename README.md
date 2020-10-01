# UFG-redes-lab03
Atividade de redes - lab03

Servidor web, feito em kotlin, com server framework Ktor 1.4.1 para resolução da atividade lab03_API_sockets_servidor_Web

Dependências do projeto em build.gradle:
``` groovy
dependencies {
   implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlin_version"
   implementation "io.ktor:ktor-server-netty:$ktor_version"
   implementation "ch.qos.logback:logback-classic:$logback_version"
}
```

Arquivo de configuração do server (porta = 8080):
``` js
ktor {
    deployment {
        port = 8080
        port = ${?PORT}
    }
    application {
        modules = [ com.alanviana.ApplicationKt.module ]
    }
}
```

Endpoint responsável pela requisição HTTP, se não encontrar o arquivo, retorna o status 404.
``` kotlin
get("/{name}") {
    File("resources/static/${call.parameters["name"]}.png").let {
        if (it.exists()) call.respondFile(it) else call.respond(HttpStatusCode.NotFound)
    }
}
```

Execução da aplicação

<img src="https://github.com/alanvianaa/UFG-redes-lab03/blob/master/doc/ide.png" />

Ao fazer uma requisição: http://0.0.0.0:8080/bulbasaur obtemos a imagem e alguns dados como tempo da requisição e o tamanho.

<img src="https://github.com/alanvianaa/UFG-redes-lab03/blob/master/doc/captura_1.png" />

Ao fazer uma requisição de um arquivo que não está presente, recebemos a página de não encontrado, com o HTTP status 404, conforme especificado no código da aplicação.

<img src="https://github.com/alanvianaa/UFG-redes-lab03/blob/master/doc/404.png" />

Fazendo o acesso por outro dispositivo, foi inserido o endereço ip da máquina server, no endpoint:
 http://192.168.1.8:8080/bulbasaur
 
<img src="https://github.com/alanvianaa/UFG-redes-lab03/blob/master/doc/captura_2.jpeg" />



