/**
 * Created by Emilio on 30/05/2017.
 */

class mainThread constructor(val greet: String) : Runnable{

    init {
        Thread(this, "Server").start();
    }

    override fun run() {
        methods(greet).build()
    }
}

fun main(args: Array<String>) {
    print("Write something: ")
    mainThread(readLine()!!)
    println("Your message will be sent to the first connection attempt...")
}