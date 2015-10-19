// BowlDriver
package main

import (
	"fmt"
	"os"
)

func main() {
	fmt.Printf("Result of test 1: %t\n", homeworkDocAddTest())
	
	fmt.Printf("Result of test 2: %t\n", homeworkDocAddTest2())
	
	fmt.Printf("Result of test 3: %t\n", simpleAdditiveTest())
	
	fmt.Printf("Result of test 4: %t\n", simpleAddTestTwo())
	
	fmt.Printf("Result of test 5: %t\n", simpleSpareTest())
	
	fmt.Printf("Result of test 6: %t\n", simpleStrikeTest())
	
	fmt.Printf("Result of test 7: %t\n", allStrikeTest())
	
	fmt.Printf("Result of test 8: %t\n", finalSpareTest())
	
	fmt.Printf("Result of test 9: %t\n", allSparesTest())
	
	
	fmt.Printf("press any key to exit...")
	b := make([]byte, 10)
	os.Stdin.Read(b)
}

func homeworkDocAddTest() bool{
	g := NewGame()
	g.add(4)
	g.add(5)
	if g.score() == 9{
		return true
	}
	return false
}

func homeworkDocAddTest2() bool{
	g := NewGame()
	g.add(3)
	g.add(7)
	g.add(3)
	g.add(2)
	
	if g.score() == 18{
		return true
	}
	return false
}


func simpleAdditiveTest() bool{
	g := NewGame()
	g.add(9)
	g.add(4)
	
	if g.score() == 13 {
		return true
	}
	return false
}

func simpleAddTestTwo() bool{
	g := NewGame()
	for i := 0; i < MAX_FRAMES; i++{
		g.add(5)
		g.add(4)
	}
	if g.score() == 90{
		return true
	}
	return false
}

func simpleSpareTest() bool{
	g := NewGame()
	g.add(9)
	g.add(1)
	g.add(3)
	
	if g.score() == 16{
		return true
	}
	
	return false
}

func simpleStrikeTest() bool{
	g := NewGame()
	g.add(10)
	g.add(3)
	g.add(4)

	if g.score() == 24{
		return true
	}
	return false
}

func allStrikeTest() bool{
	g := NewGame()
	
	for i:= 0; i < MAX_FRAMES; i++{
		g.add(10)

	}
	g.add(10)
	g.add(10)

	if g.score() == 300{
		return true
	}
	return false
}

func finalSpareTest() bool{
	g := NewGame()
	for i:= 0; i < MAX_FRAMES - 1; i++{
		g.add(1)
		g.add(1)
	}
	g.add(5)
	g.add(5)
	g.add(2)
	
	if g.score() == 30{
		return true
	}
	return false
}

func allSparesTest() bool{
	g := NewGame()
	
	for i:= 0; i < MAX_FRAMES ; i++{
		g.add(5)
		g.add(5)
	}
	g.add(5)
	
	if g.score() == 150{
		return true
	}
	return false
}