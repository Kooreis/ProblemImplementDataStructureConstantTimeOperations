import collections

class AllOne:
    def __init__(self):
        self.keys = collections.defaultdict(int)
        self.counts = collections.defaultdict(collections.deque)
        self.maxCount = 0
        self.minCount = float('inf')
        self.counts[0] = collections.deque([''])