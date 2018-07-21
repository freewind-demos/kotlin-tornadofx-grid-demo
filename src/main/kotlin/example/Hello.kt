package example

import javafx.geometry.Pos
import tornadofx.*
import com.sun.javafx.robot.impl.FXRobotHelper.getChildren
import javafx.geometry.Insets
import javafx.scene.control.Label
import javafx.scene.layout.Pane


class HelloWorld : View() {
    override val root = gridpane {
        row {
            label("Username") {
                useMaxWidth = true
                gridpaneConstraints {
                    marginBottom = 10.0
                    columnSpan = 2
                }
            }
            textfield()
        }
        row {
            label("Password")
            passwordfield { }
        }
        row {
            label("")
            button("Login") {
                gridpaneConstraints {
                    this.columnIndex = 3
                }
            }
        }
        gridpaneConstraints {
            padding = Insets(10.0, 10.0, 10.0, 10.0)
            hgap = 10.0
            vgap = 10.0
        }
    }

    private fun cell(label: String): Pane {
        return object : Pane() {
            init {
                style = "-fx-background-color: RED"
                prefWidth = 50.0
                prefHeight = 50.0
                children.add(Label(label))
            }
        }
    }
}

class HelloWorldStyle : Stylesheet() {
    init {
        root {
            prefWidth = 400.px
            prefHeight = 400.px
        }
    }
}

class HelloWorldApp : App(HelloWorld::class, HelloWorldStyle::class)

fun main(args: Array<String>) {
    launch<HelloWorldApp>()
}