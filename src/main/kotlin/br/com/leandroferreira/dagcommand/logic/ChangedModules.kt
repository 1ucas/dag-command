package br.com.leandroferreira.dagcommand.logic

import br.com.leandroferreira.dagcommand.utils.CommandExecutor

fun changedModules(commandExec: CommandExecutor): List<String> =
    commandExec.runCommand("git diff --dirstat=files").map(::parseModuleName)

private fun parseModuleName(commandResult: String): String =
    commandResult.trimStart()
        .split(" ", limit = 2)[1]
        .split("/", limit = 2)[0]