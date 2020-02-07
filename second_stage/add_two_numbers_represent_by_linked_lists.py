class Node:

    # Constructor to initialize the node object
    def __init__(self, data):
        self.data = data
        self.next = None


class LinkedList:
    def __init__(self):
        self.head = None

    def push(self, new_data):
        new_node = Node(new_data)
        new_node.next = self.head
        self.head = new_node

    def add_two_lists(self, first, second):
        prev = temp = None
        carry = 0

        while first or second:
            fd = first.data if first else 0
            sd = second.data if second else 0
            sum = carry + fd + sd

            carry = int(sum >= 10)
            if sum >= 10:
                sum %= 10

            temp = Node(sum)

            if not self.head:
                self.head = temp
            else:
                prev.next = temp

            prev = temp

            if first:
                first = first.next

            if second:
                second = second.next

        if carry:
            temp.next = Node(carry)

    def print_list(self):
        temp = self.head
        while temp:
            print(temp.data)
            tmep = temp.next


# description: https://www.geeksforgeeks.org/add-two-numbers-represented-by-linked-lists/
if __name__ == '__main__':
    first = LinkedList()
    second = LinkedList()

    first.push(6)
    first.push(4)
    first.push(9)
    first.push(5)
    first.push(7)
    # first.print_list()

    # Create second list
    second.push(4)
    second.push(8)
    # second.print_list()

    # Add the two lists and see result
    res = LinkedList()
    res.add_two_lists(first.head, second.head)
    res.print_list()