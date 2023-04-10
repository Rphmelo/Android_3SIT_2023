package br.com.fiap.chatgpt.data

object TalkDataSource {

    val talkList: List<TalkModel> = listOf(
        TalkModel(
            "Qual é o planeta mais próximo do sol?",
            listOf(
                AnswerModel("Mercúrio é o planeta mais próximo do sol.", true),
                AnswerModel("Por ser muito próximo do sol, Mercúrio é conhecido como planeta vermelho, pois é um planeta muito quente."),
                AnswerModel("Distância do Sol: 57.910.000 de quilômetros."),
                AnswerModel("Massa: 3.302×1023 kg (330 bilhões de bilhões de toneladas).")
            )
        ),
        TalkModel(
            "O que é Kotlin?",
            listOf(
                AnswerModel("Kotlin é uma linguagem de programação multiplataforma, orientada a objetos e funcional, concisa e estaticamente tipada, desenvolvida pela JetBrains em 2011."),
                AnswerModel("Ela compila na Java Virtual Machine (JVM)."),
                AnswerModel("Os recursos modernos da linguagem Kotlin permitem que você se concentre em expressar suas ideias e escrever menos código boilerplate.", true),
                AnswerModel("Com a nulidade inclusa no sistema de tipo, o Kotlin ajuda a evitar NullPointerExceptions. Os apps Android que usam código Kotlin têm 20% menos chances de apresentar falhas."),
                AnswerModel("Muitos apps já são criados usando o Kotlin, tanto em startups de destaque quanto em empresas da Fortune 500.")

            )
        ),
        TalkModel(
            "Quem é Elon Musk?",
            listOf(
                AnswerModel("Elon Musk é um empreendedor, empresário e filantropo sul-africano-canadense, naturalizado norte-americano."),
                AnswerModel("Ele é o fundador, diretor executivo e diretor técnico da SpaceX;"),
                AnswerModel("CEO da Tesla", true),
                AnswerModel("vice-presidente da OpenAI"),
                AnswerModel("fundador e CEO da Neuralink"),
                AnswerModel("proprietário do Twitter", true)

            )
        ),
        TalkModel(
            "O Palmeiras tem mundial?",
            listOf(
                AnswerModel("Não."),
                AnswerModel("O Palmeiras não tem mundial!", true)
            )
        ),
        TalkModel(
            "Qual a melhor faculdade de tecnologia?",
            listOf(
                AnswerModel("A melhor Faculdade de Tecnologia é a FIAP"),
                AnswerModel("Recentemente, a Alura e a FIAP se fundiram para melhorar a educação de tecnologia no Brasil"),
                AnswerModel("A FIAP tem os melhores professores.", true),
                AnswerModel("Todos os alunos que estudam na FIAP são bem sucedidos.", true)
            )
        ),
        TalkModel(
            "Quanto é 12 - 7?",
            listOf(
                AnswerModel("12 - 7 = 5", true)
            )
        )
    )
}