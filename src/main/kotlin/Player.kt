data class Player(
    var pilihan: String? = null
){
    fun pilihSuit(){
        pilihan = readln().lowercase()
    }
}