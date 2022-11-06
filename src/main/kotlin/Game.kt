abstract class Game {
    private var isRunning = false
    var result: String? = null

    abstract fun process()
    abstract fun processBatu(pilihanSuit2: String?): String?
    abstract fun processGunting(pilihanSuit2: String?): String?
    abstract fun processKertas(pilihanSuit2: String?): String?
    abstract fun showResult(result: String?)

    fun start(){
        isRunning = true

        while (isRunning){
            process()
            if (result !== null) stop()
        }
    }

    fun stop(){
        isRunning = false
    }
}