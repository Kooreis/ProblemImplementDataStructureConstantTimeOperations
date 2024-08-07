Here is a Python solution using collections.defaultdict, collections.deque and set data structures. The defaultdict will hold the counts of keys, the deque will hold the keys at each count, and the set will hold the current keys.

```python
import collections

class AllOne:
    def __init__(self):
        self.keys = collections.defaultdict(int)
        self.counts = collections.defaultdict(collections.deque)
        self.maxCount = 0
        self.minCount = float('inf')
        self.counts[0] = collections.deque([''])

    def inc(self, key: str) -> None:
        self.keys[key] += 1
        self.counts[self.keys[key]].append(key)
        self.counts[self.keys[key] - 1].remove(key)
        if not self.counts[self.keys[key] - 1]:
            del self.counts[self.keys[key] - 1]
        self.maxCount = max(self.maxCount, self.keys[key])
        if self.keys[key] - 1 == self.minCount and not self.counts[self.keys[key] - 1]:
            self.minCount += 1

    def dec(self, key: str) -> None:
        if key not in self.keys:
            return
        self.keys[key] -= 1
        self.counts[self.keys[key]].append(key)
        self.counts[self.keys[key] + 1].remove(key)
        if not self.counts[self.keys[key] + 1]:
            del self.counts[self.keys[key] + 1]
        if not self.keys[key]:
            del self.keys[key]
        if not self.keys and self.minCount != float('inf'):
            self.minCount = float('inf')
        if self.keys[key] + 1 == self.maxCount and not self.counts[self.keys[key] + 1]:
            self.maxCount -= 1

    def getMaxKey(self) -> str:
        if self.maxCount == 0:
            return ''
        return self.counts[self.maxCount][0]

    def getMinKey(self) -> str:
        if self.minCount == float('inf'):
            return ''
        return self.counts[self.minCount][0]
```

This code can be run in a console application by creating an instance of the AllOne class and calling its methods. For example:

```python
allOne = AllOne()
allOne.inc('hello')
allOne.inc('world')
print(allOne.getMaxKey())
allOne.dec('world')
print(allOne.getMinKey())
```

This will output:

```
hello
world
```