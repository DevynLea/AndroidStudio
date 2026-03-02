package com.example.proj1rockpaperscissors

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var playerScore = 0
    private var computerScore = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val playerScoreText = findViewById<TextView>(R.id.playerScoreText)
        val computerScoreText = findViewById<TextView>(R.id.computerScoreText)
        val winnerStatus = findViewById<TextView>(R.id.winnerStatus)


        val computerImage = findViewById<ImageView>(R.id.computerImage)
        val playerImage = findViewById<ImageView>(R.id.playerImage)

        val roundResultText = findViewById<TextView>(R.id.roundResultText)


        val rockButton = findViewById<Button>(R.id.rockButton)
        val paperButton = findViewById<Button>(R.id.paperButton)
        val scissorsButton = findViewById<Button>(R.id.scissorsButton)
        val playAgainButton = findViewById<Button>(R.id.playAgainButton)


        rockButton.setOnClickListener {
            playRound(
                "rock",
                computerImage,
                playerImage,
                roundResultText,
                playerScoreText,
                computerScoreText,
                winnerStatus,
                rockButton,
                paperButton,
                scissorsButton,
                playAgainButton
            )

        }

        paperButton.setOnClickListener {
            playRound(
                "paper",
                computerImage,
                playerImage,
                roundResultText,
                playerScoreText,
                computerScoreText,
                winnerStatus,
                rockButton,
                paperButton,
                scissorsButton,
                playAgainButton
            )

        }

        scissorsButton.setOnClickListener {
            playRound(
                "scissors",
                computerImage,
                playerImage,
                roundResultText,
                playerScoreText,
                computerScoreText,
                winnerStatus,
                rockButton,
                paperButton,
                scissorsButton,
                playAgainButton
            )

        }

        playAgainButton.setOnClickListener {
            playerScore = 0
            computerScore = 0


            playerScoreText.text = "Player score: 0"
            computerScoreText.text = "Computer score: 0"
            winnerStatus.text = "No winner yet"
            roundResultText.text = ""


            playAgainButton.visibility = Button.GONE


            rockButton.isEnabled = true
            paperButton.isEnabled = true
            scissorsButton.isEnabled = true




            computerImage.setImageResource(R.drawable.rock)
            playerImage.setImageResource(R.drawable.paper)

        }


        }

    private fun playRound(
        playerChoice: String,
        computerImage: ImageView,
        playerImage: ImageView,
        roundResultText: TextView,
        playerScoreText: TextView,
        computerScoreText: TextView,
        winnerStatus: TextView,
        rockButton: Button,
        paperButton: Button,
        scissorsButton: Button,
        playAgainButton: Button
    ) {
        val choices = listOf("rock", "paper", "scissors")
        val computerChoice = choices.random()


        val rockImg = R.drawable.rock
        val paperImg = R.drawable.paper
        val scissorsImg = R.drawable.scissors

        playerImage.setImageResource(
            when (playerChoice) {
                "rock" -> rockImg
                "paper" -> paperImg
                else -> scissorsImg
            }
        )

        computerImage.setImageResource(
            when (computerChoice) {
                "rock" -> rockImg
                "paper" -> paperImg
                else -> scissorsImg
            }
        )

        val result = when {
            playerChoice == computerChoice -> "Tie!"
            playerChoice == "rock" && computerChoice == "scissors" -> "Player wins!"
            playerChoice == "paper" && computerChoice == "rock" -> "Player wins!"
            playerChoice == "scissors" && computerChoice == "paper" -> "Player wins!"
            else -> "Computer wins!"
        }

        roundResultText.text = result


        if (result == "Player wins!") {
            playerScore++
        } else if (result == "Computer wins!") {
            computerScore++
        }

        playerScoreText.text = "Player score: $playerScore"
        computerScoreText.text = "Computer score: $computerScore"

        if (playerScore == 10 || computerScore == 10) {


            winnerStatus.text =
                if (playerScore == 10) "Player wins game!"
                else "Computer wins game!"


            rockButton.isEnabled = false
            paperButton.isEnabled = false
            scissorsButton.isEnabled = false

            playAgainButton.visibility = Button.VISIBLE
        }
    }

    }
