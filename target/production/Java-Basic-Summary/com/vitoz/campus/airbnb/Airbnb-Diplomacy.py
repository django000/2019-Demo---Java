from collections import Counter

# Complete the evaluateActions function below.


def evaluateActions(actions):
    total = {}
    for _, item in enumerate(actions):
        tmp = item.split()
        total[tmp[0]] = [tmp[1], 1]
        if tmp[2] == "Move":
            total[tmp[0]][0] = tmp[-1]
    count = Counter(map(lambda x: x[0], total.values()))
    tmpList = [x for x, y in count.items() if y > 1]
    for _, item in enumerate(actions):
        tmp = item.split()
        if tmp[2] == "Support" and total[tmp[0]][0] not in tmpList:
            total[tmp[-1]][-1] += 1
    strengthDict = {}
    for x in tmpList:
        strengthDict[x] = max([cont[-1] for cont in total.values() if cont[0] == x])
    for _, y in enumerate(total.values()):
        if y[0] in tmpList and y[-1] != strengthDict[y[0]]:
            y[0] = "[dead]"
    return [army + " " + cont[0] for army, cont in total.items()]

if __name__ == '__main__':
    actions = ["A Russia Support B", "B Oakland Move Munich",
               "C Oakland Move Munich", "D Prussia Support B", "E America Support C"]
    res = evaluateActions(actions)
    print(res)
