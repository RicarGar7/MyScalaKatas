package org.example

// this is a Scala class
class Kata(val dependency: Dependency) {
    def getValue: Int = {
        dependency.getValue
    }
}
