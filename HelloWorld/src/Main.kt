fun main() {
    // Print text in console
    println("Hello World!")

    //constant
    val myName: String = "Bruno Vicente"

    // variable
    var age: Int = 19

    println(imprimirSoma(age, 8))

    // Array
    val names = listOf("Bruno", "Vicente", "Tarsila", "Reis")
    println(names[1])

    println("\n**************\nThe names are:")

    // For Loop
    for (name in names) {
        println(name)
    }

    // Template Strings
    println("\nMy name is $myName and I am $age years old, ${if (age > 18) "and I can vote" else "and I can't vote"}")

    println("\nFirst letter of my name is ${myName.first()}, and the last letter is ${myName.last()}")
}

// Declaring Functions
fun imprimirSoma(a: Int, b: Int): Int {
    return a + b;
}