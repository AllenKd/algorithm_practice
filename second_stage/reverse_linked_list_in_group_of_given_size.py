class Node:

    # Constructor to initialize the node object
    def __init__(self, data):
        self.data = data
        self.next = None


class LinkedList:
    def __init__(self):
        self.head = None

    def reverse(self, head, k):
        current = head
        nex = pre = None
        count = 0

        while current and count < k:
            nex = current.next
            current.next = pre
            pre = current
            current = nex
            count += 1

        if nex:
            head.next = self.reverse(nex, k)
        return pre

    def push(self, new_data):
        new_node = Node(new_data)
        new_node.next = self.head
        self.head = new_node

        # Utility function to print the linked LinkedList

    def printList(self):
        temp = self.head
        while temp:
            print(temp.data)
            temp = temp.next


# description: https://www.geeksforgeeks.org/reverse-a-list-in-groups-of-given-size/
if __name__ == '__main__':
    llist = LinkedList()
    llist.push(9)
    llist.push(8)
    llist.push(7)
    llist.push(6)
    llist.push(5)
    llist.push(4)
    llist.push(3)
    llist.push(2)
    llist.push(1)

    # llist.printList()
    llist.head = llist.reverse(llist.head, 3)
