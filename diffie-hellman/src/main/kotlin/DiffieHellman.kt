import java.math.BigInteger
import kotlin.random.Random

object DiffieHellman {


    private val usedPrivateKeyList = mutableListOf<BigInteger>()


    /**
     * make random value but not conflict
     */
    fun privateKey(prime: BigInteger): BigInteger {
        val rand = (Random.nextInt(prime.toInt() - 1) + 1).toBigInteger()
        if (usedPrivateKeyList.contains(rand)) {
            usedPrivateKeyList.add(rand)
            privateKey(prime)
        }
        return rand
    }

    fun publicKey(p: BigInteger, g: BigInteger, privKey: BigInteger): BigInteger {
        return g.pow(privKey.toInt()) % p
    }

    fun secret(prime: BigInteger, publicKey: BigInteger, privateKey: BigInteger): BigInteger {
        return publicKey.pow(privateKey.toInt()) % prime
    }
}
