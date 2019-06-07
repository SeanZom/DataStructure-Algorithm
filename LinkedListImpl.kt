
/**
 *  Implementation of LinkedList
 */

fun main(args: Array<String>) {

    val e1 = MyObj(1)
    val e2 = MyObj(2)
    val e3 = MyObj(3)
    val e4 = MyObj(4)

    val mll = MyLinkedList(e1)
                .apply {
                    append(e2)
                    append(e3)
                }

    println(mll.head?.next?.next?.value)

    println(mll.getPosition(3)?.value)

    mll.insert(e4, 3)
    println(mll.getPosition(3)?.value)

    mll.delete(1)

    mll.also {
        println(it.getPosition(1)?.value)
        println(it.getPosition(2)?.value)
        println(it.getPosition(3)?.value)
    }

}

data class MyObj(var value: Int, var next: MyObj? = null)

class MyLinkedList(var head: MyObj? = null) {

    fun append(newObj: MyObj) {
        var current = head
        if (head == null) {
            head = newObj
        } else {
            while (current?.next != null) {
                current = current.next
            }
            current!!.next = newObj
        }
    }

    fun getPosition(index: Int): MyObj? {
        var current = head
        var i = 1
        while (current?.next != null) {
            if (i == index) {
                return current
            }
            current = current.next
            i++
        }

        return if (i == index) {
            current
        } else {
            null
        }

        /* Answer from tutorial*/
        /* var counter = 1
        var current = head
        if (index < 1) {
            return null
        }
        while (current != null && counter <= index) {
            if (counter == index) {
                return current
            }
            current = current.next
            counter ++
        }

        return null */
    }

    fun insert(newObj: MyObj, index: Int) {
        var prev = head
        if (index == 0) {
            newObj.next = prev
            head = newObj
        } else {
            var i = 1
            var current = prev?.next
            while (current?.next != null) {
                if (i == index) {
                    break
                }
                i++
                prev = current
                current = current.next
            }
            prev?.next = newObj
            newObj.next = current
        }

        /* Answer from tutorial */
        /* var counter = 1
        var current = head
        if (index > 1) {
            while (current != null && counter < index) {
                if (counter == index - 1) {
                    newObj.next = current.next
                    current.next = newObj
                }
                current = current.next
                counter ++
            }
        } else if (index == 1) {
            newObj.next = head
            head = newObj
        } */
    }

    fun delete(value: Int) {
        if (head != null) {
            if (value == head?.value) {
                if (head?.next != null) {
                    head = head?.next
                } else {
                    head = null
                }
            } else {
                var prev = head
                var current = prev?.next
                while (current?.next != null) {
                    if (value == current.value) {
                        prev?.next = current.next
                        current.next = null
                        break
                    }
                    prev = current
                    current = current.next
                }
            }
        }

        /* Answer from tutorial */
        /* var current = head
        var previous: MyObj? = null
        while (current?.value != value && current?.next != null) {
            previous = current
            current = current.next
        }
        if (current?.value == value) {
            if (previous != null) {
                previous.next = current.next
            } else {
                head = current.next
            }
        } */
    }

}