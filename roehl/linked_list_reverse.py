class Node:
    def __init__(self, data):
        self.data = data
        self.next = None


def reverse_linked_list_r(head):
    if not head or head.next:
        return head
    p = reverse_linked_list_r(head.next)

    # reverse order
    head.next.next = head
    head.next = None
    return p


def reverse_linked_list_i(head):
    pre = None
    cur = head
    while cur:
        tmp_next = cur.next
        cur.next = pre
        pre = cur
        cur = tmp_next
    return pre


if __name__ == '__main__':
    head = Node(1)
    tail = head
    for i in range(2, 5):
        tail.next = Node(i)
        tail = tail.next

    reverse_linked_list_i(head)
    reverse_linked_list_r(head)
