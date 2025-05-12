package com.example.shapegame

data class Question(
    val imageRes: Int,
    val correctAnswer: String,
    val options: List<String>
)

val grade1Questions = listOf(
    Question(R.drawable.circle, "Circle", listOf("Circle", "Square", "Triangle", "Rectangle")),
    Question(R.drawable.square, "Square", listOf("Circle", "Square", "Triangle", "Rectangle")),
    Question(R.drawable.triangle, "Triangle", listOf("Circle", "Square", "Triangle", "Rectangle")),
    Question(R.drawable.rectangle, "Rectangle", listOf("Circle", "Square", "Triangle", "Rectangle")),
    Question(R.drawable.star, "Star", listOf("Circle", "Square", "Star", "Triangle"))
)

val grade2Questions = grade1Questions + listOf(
    Question(R.drawable.oval, "Oval", listOf("Oval", "Diamond", "Hexagon", "Circle")),
    Question(R.drawable.diamond, "Diamond", listOf("Oval", "Diamond", "Hexagon", "Square")),
    Question(R.drawable.hexagon, "Hexagon", listOf("Oval", "Diamond", "Hexagon", "Triangle"))
)

val grade3Questions = grade2Questions + listOf(
    Question(R.drawable.cone, "Cone", listOf("Cone", "Cube", "Sphere", "Cylinder")),
    Question(R.drawable.cube, "Cube", listOf("Cone", "Cube", "Sphere", "Cylinder")),
    Question(R.drawable.sphere, "Sphere", listOf("Cone", "Cube", "Sphere", "Cylinder")),
    Question(R.drawable.cylinder, "Cylinder", listOf("Cone", "Cube", "Sphere", "Cylinder")),
    Question(R.drawable.pentagon, "Pentagon", listOf("Pentagon", "Hexagon", "Octagon", "Circle")),
    Question(R.drawable.octagon, "Octagon", listOf("Pentagon", "Hexagon", "Octagon", "Square"))
)
