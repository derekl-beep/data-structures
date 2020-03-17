'''
Original author:
YouTube Channel: Code Drip
Video: https://youtu.be/ne1iyAP9__o

Modified by: Derek
Date: Mar 18, 2019
Included:
    self.print()
    self.print_memory_address()
    Illustrution with examples
'''

class Node:
    # Constructor of the Node class
    def __init__(self, value):
        self.value = value
        self.next = None

    # Method: Add a new value to the linked list
    # Complexity: O(n)
    def add_to_tail(self, value):
        on = self
        while on.next:
            on = on.next
        on.next = Node(value)

    # Method: Retrieve a value by its index
    # Complexity: O(n)
    def get_at_index(self, index):
        on = self
        while on and index:
            on = on.next
            index = index - 1
        if on:
            return on.value
        else:
            return False

    # Method: Delete a value by its value
    # Complexity: O(n)
    def delete_by_value(self, value):
        on = self
        while on and on.next:
            if on.next.value == value:
                on.next = on.next.next
            on = on.next

    # Method: Print out the linked list elements
    def print(self):
        on = self
        values = [on.value]
        while on.next:
            on = on.next
            values.append(on.value)
        print(values)

    # Method: Print out memory addresses of the linked list elements
    def print_memory_address(self):
        on = self
        addresses = [hex(id(on))]
        while on.next:
            on = on.next
            addresses.append(hex(id(on)))
        print(addresses)

# Illustrations

# Create a linked list with value 0
# by using the constructor
my_list = Node(0)
print('A linked list is constructed with the initial node being: ')
my_list.print()

# Create a linked list with value from 0 to 6
# by using self.add_to_tail
for i in range(6):
    my_list.add_to_tail(i+1)
print('The linked list is expanded to: ')
my_list.print()

# Delete the value 3print
# by using self.delete_by_value()
my_list.delete_by_value(3)
print('The node with value 3 is deleted: ')
my_list.print()

# Delete the last node with value 6
# by using self.delete_by_value()
my_list.delete_by_value(6)
print('The node with value 6 is deleted: ')
my_list.print()

# Print the memory address of the linked list
# by using self.print_memory_address()
print('The memory address of the nodes are: ')
my_list.print_memory_address()

#
arr = [0, 1, 2, 3, 4]
addresses = []
for num in arr:
    addresses.append(hex(id(num)))
print('Comparing with an array with the same size, ')
print('the memory address are: ')
print(addresses)