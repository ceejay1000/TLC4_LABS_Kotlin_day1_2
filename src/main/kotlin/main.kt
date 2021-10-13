var funds : Double = 100.0
val pswd = "password"

fun main() {
    var input : String
    var cmd : List<String>
    var amt: String

    while (true) {
        print("Command: ")
        input = readLine()!!
        cmd = input.split(" ")
        when (cmd[0]) {
            // Each command goes here...
                "balance" -> balance()
                "deposit" -> deposit(cmd[1].toDouble())
                "withdraw" -> withdraw(cmd[1].toDouble())
            else -> println("Invalid command")
        }
    }
}

fun balance(): Unit {
     println(funds)
}

fun deposit(amount: Double): Unit{

    if(amount.isNaN() || amount < 0 || amount == null){
        println("Invalid amount entered")
    }

    funds += amount
    balance()
}

fun withdraw(amount: Double): Unit{
    print("Please enter your password -> ")
    var password = readLine()!!
    password = password.trim()

    if((password != pswd)){
        println("Invalid password. You're an imposter :/")
        return
    }

    if ((amount > funds) || (amount < 0 || amount.isNaN())){
        println("Invalid amount entered or funds not sufficient :/")
        return
    }

    funds -= amount
    println("Your new balance is $funds")

}