import java.io.ObjectOutputStream
import java.net.InetAddress
import java.net.ServerSocket

/**
 * Created by Emilio on 30/05/2017.
 */

class methods(val greet: String) {

    public fun build(){
        println("Waiting for client...")
        val server = ServerSocket(1337)
        val conn = server.accept();
        if (conn.isConnected){
            val guest = conn.remoteSocketAddress
            println("$guest connected!")
            server.close()

            val output = ObjectOutputStream(conn.getOutputStream())
            val host = InetAddress.getLocalHost().hostName
            val data = data(host, greet)
            output.writeObject(data)
            output.flush()
            output.close()
            println("Job finished. Sent $greet from $host")
        }
    }
}