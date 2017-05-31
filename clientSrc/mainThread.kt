import java.io.ObjectInputStream
import java.net.Socket

/**
 * Created by Emilio on 30/05/2017.
 */


fun main(args: Array<String>) {
    println("I am meant to receive something from someone...")
    println("Tell me which machine shall I Connect:")
    val server = readLine()!!

    val conn = Socket(server, 1337)
    if (conn.isConnected) handshake(conn)
}

fun handshake(conn: Socket){
    val input = ObjectInputStream(conn.getInputStream())
    val result:data = input.readObject() as data
    println("Got it!")
    println("${result.user} says ${result.msg}")
}