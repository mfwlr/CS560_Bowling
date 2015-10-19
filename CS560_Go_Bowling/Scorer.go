// Scorer
package main

import (
)

const MAX_ROLL_SPOTS int = 22
const MAX_FRAMES int = 10
const MAX_ROLL int = 10
const FIRST_BALL int = 0
const SECOND_BALL int = 1

type Scorer struct{
	scores [22]int //Initializes to zero by default
	curBall int
	strikeFrames [10]bool
	spareFrames [10]bool
}

func NewScorer() Scorer{
	var sf [10]bool
	var spf [10]bool
	var sc [22]int //Zero by default
	for i:= 0 ; i < MAX_FRAMES ; i++{
		sf[i] = false
		spf[i] = false
	}
	return Scorer{sc, 0, sf, spf}
}

func (sc *Scorer) returnScore(frame int) int{
	ballPointer1 := frame * 2
	ballPointer2 := frame * 2 + 1
	score := sc.scores[ballPointer1] + sc.scores[ballPointer2]
	
	if sc.strikeFrames[frame]{
		if frame < MAX_FRAMES - 2 && 
		sc.strikeFrames[frame + 1] && 
		sc.strikeFrames[frame + 2]{
			return sc.scores[ballPointer1] + sc.scores[ballPointer1 + 2] + sc.scores[ballPointer1 + 4]
		}else if frame < MAX_FRAMES - 1 && sc.strikeFrames[frame+1]{
			return sc.scores[ballPointer1] + sc.scores[ballPointer1 + 2] + sc.scores[ballPointer1 + 3]
		}else{
			if frame == MAX_FRAMES - 1{
				score = sc.scores[ballPointer1] + sc.scores[ballPointer2 + 1]
				if sc.scores[ballPointer2+1] == 10{
					return score + 2 * sc.scores[ballPointer2 + 2]
				}else{
					return score + sc.scores[ballPointer2 + 2]
				}
			}
			return sc.scores[ballPointer1] + sc.scores[ballPointer1 + 2] + sc.scores[ballPointer1 + 3]
		}
	}else if sc.spareFrames[frame]{
		return score + sc.scores[ballPointer2 + 1]
	}
	
	return score
}

func (sc *Scorer) add(pins int, ball int, frame int){
	sc.scores[sc.curBall] = pins;
	if pins == MAX_ROLL && ball == FIRST_BALL{
		sc.strikeFrames[frame] = true
		sc.curBall++
	}else if ball == SECOND_BALL{
			if sc.scores[sc.curBall] + sc.scores[sc.curBall - 1] == MAX_ROLL{
				sc.spareFrames[frame] = true
			}
	}
	sc.curBall++
}