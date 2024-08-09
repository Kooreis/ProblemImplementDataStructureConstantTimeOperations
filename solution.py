def inc(self, key: str) -> None:
        self.keys[key] += 1
        self.counts[self.keys[key]].append(key)
        self.counts[self.keys[key] - 1].remove(key)
        if not self.counts[self.keys[key] - 1]:
            del self.counts[self.keys[key] - 1]
        self.maxCount = max(self.maxCount, self.keys[key])
        if self.keys[key] - 1 == self.minCount and not self.counts[self.keys[key] - 1]:
            self.minCount += 1