"""Implement quick sort in Python.
Input a list.
Output a sorted list."""
def quicksort(array):
    divider = len(array) - 1
    i = 0
    first_divider = -1
    head_end = False

    while i < divider:
        while i < divider:
            if array[i] > array[divider]:
                temp = array[i]
                array[i] = array[divider - 1]
                array[divider - 1] = array[divider]
                array[divider] = temp
                divider -= 1
            else:
                i += 1

        if first_divider < 0:
            first_divider = divider
        
        if head_end:
            i = first_divider + 1
        else:
            i = 0
        divider -= 1

        if divider == 0 and head_end is not True:
            head_end = True
            i = first_divider + 1
            divider = len(array) - 1

    return array

test = [21, 4, 1, 3, 9, 20, 25, 6, 21, 14]
print quicksort(test)