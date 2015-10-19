// Game
package main

import (
)

type Game struct{
	sc Scorer
	currentFrame, throwCount int
	
}

func NewGame() Game{
	return Game{NewScorer(), 0, 0}
}

func (game *Game) score() int{
	score := 0
	for frame := 0; frame <= game.currentFrame; frame++{
		score = score + game.sc.returnScore(frame)
	}
	return score
}

func (game *Game) add(pins int){
	game.sc.add(pins, game.throwCount, game.currentFrame)
	if pins == MAX_ROLL && game.currentFrame < (MAX_FRAMES - 1){
		game.throwCount = game.throwCount + 2
	}else{
		game.throwCount++
	}
	
	if game.currentFrame < (MAX_FRAMES - 1) && game.throwCount % 2 == 0{
		game.currentFrame++
		game.throwCount = 0
	}
}

