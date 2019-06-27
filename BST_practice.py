class Node(object):
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

class BST(object):
    def __init__(self, root):
        self.root = Node(root)

    def insert(self, new_val):
        if self.root.value:
            current = self.root
            while current:
                next_node = current.left if new_val < current.value else current.right
                if next_node is None:
                    next_node = Node(new_val)
                    break
                current = next_node
        else:
            self.root.value = new_val

    def search(self, find_val):
        if self.root.value:
            current = self.root
            while current:
                if find_val == current.value:
                    return True
                current = current.left if find_val < current.value else current.right
        return False
    
# Set up tree
tree = BST(4)

# Insert elements
tree.insert(2)
tree.insert(1)
tree.insert(3)
tree.insert(5)


# Check search
# Should be True
print(tree.search(4))
# Should be False
print(tree.search(6))