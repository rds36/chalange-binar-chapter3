class GameImpl : Game() {
    private val player1 = Player()
    private val player2 = Player()

    override fun process(){
        Text.printTitle()
        playerDoInput()

        if (player1.pilihan == null || player2.pilihan == null) {
            result = null
        }
        result = when (player1.pilihan) {
            PilihanSuit.BATU.value -> processBatu(player2.pilihan)
            PilihanSuit.GUNTING.value -> processGunting(player2.pilihan)
            PilihanSuit.KERTAS.value -> processKertas(player2.pilihan)
            else -> null
        }

        showResult(result)
    }

    override fun processBatu(pilihanSuit2: String?): String? {
        var result: String? = null
        result = when (pilihanSuit2) {
            PilihanSuit.BATU.value -> "DRAW!"
            PilihanSuit.GUNTING.value -> "Pemain 1 MENANG!"
            PilihanSuit.KERTAS.value ->"Pemain 2 MENANG!"
            else -> null
        }
        return result
    }

    override fun processGunting(pilihanSuit2: String?): String? {
        var result: String? = null

        result =
            when (pilihanSuit2) {
                PilihanSuit.BATU.value -> "Pemain 2 MENANG!"
                PilihanSuit.GUNTING.value -> "DRAW!"
                PilihanSuit.KERTAS.value -> "Pemain 1 MENANG!"
                else -> null
            }
        return result
    }

    override fun processKertas(pilihanSuit2: String?): String? {
        var result: String? = when (pilihanSuit2) {
                PilihanSuit.BATU.value -> "Pemain 1 MENANG!"
                PilihanSuit.GUNTING.value -> "Pemain 2 MENANG!"
                PilihanSuit.KERTAS.value -> "DRAW!"
                else -> null
            }
        return result
    }

    override fun showResult(result: String?) {
        if (result == null) {
            Text.printError()
        } else {
            println(result)
        }
    }

    private fun playerDoInput() {
        println("1. Masukkan pemain 1: ")
        player1.pilihSuit()

        println("2. Masukkan pemain 2: ")
        player2.pilihSuit()
    }
}