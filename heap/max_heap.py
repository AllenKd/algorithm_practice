class MaxHeap:
    def __init__(self):
        self.data = []

    def insert(self, value):
        self.data.append(value)

    def _swim(self):
        k = len(self.data)
        while k > 0 and self.data[(k - 1) // 2] < self.data[k]:
            self._swap((k - 1) // 2, k)
            k = (k - 1) // 2

    def _swap(self, i, j):
        self.data[i], self.data[j] = self.data[j], self.data[i]
