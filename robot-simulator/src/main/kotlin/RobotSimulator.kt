import Orientation.*
class Robot(var gridPosition: GridPosition = GridPosition(x = 0, y = 0),var orientation: Orientation = NORTH) {

    // TODO: implement proper constructor, provide read access to `gridPosition` and `orientation`


    fun advance() {
        gridPosition = when (orientation) {
            NORTH -> GridPosition(gridPosition.x,     gridPosition.y + 1)
            EAST  -> GridPosition(gridPosition.x + 1, gridPosition.y)
            WEST  -> GridPosition(gridPosition.x - 1, gridPosition.y)
            SOUTH -> GridPosition(gridPosition.x,     gridPosition.y - 1)
        }
    }

    fun turnLeft() {
        orientation = when (orientation) {
            NORTH -> WEST
            EAST  -> NORTH
            WEST  -> SOUTH
            SOUTH -> EAST
        }
    }

    fun turnRight() {
        orientation = when (orientation) {
            NORTH -> EAST
            EAST  -> SOUTH
            WEST  -> NORTH
            SOUTH -> WEST
        }
    }

    fun simulate(instructions: String) {
        instructions.forEach {
            when(it){
                'L' -> turnLeft()
                'R' -> turnRight()
                'A' -> advance()
            }
        }
    }
}
