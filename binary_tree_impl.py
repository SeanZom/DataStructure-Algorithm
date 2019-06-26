class Node(object):
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

class BinaryTree(object):
    def __init__(self, root):
        self.root = Node(root)

    def search(self, find_val):
        if self.root:
            return self.preorder_search(self.root, find_val)
        else:
            return False

        # Official Answer:
        # return self.preorder_search(self.root, find_val)
        

    def print_tree(self):
        return self.preorder_print(self.root, "{}".format(self.root.value))

        # Official Answer:
        # return self.preorder_print(self.root, "")[:-1]

    def preorder_search(self, start, find_val):
        if start.value == find_val:
            return True
          
        if start.left is not None:
            next_left = self.preorder_search(start.left, find_val)
            if next_left:
                return True
    
        if start.right is not None:
            next_right = self.preorder_search(start.right, find_val)
            if next_right:
                return True

        return False

        # Official Answer:
        # if start:
        #     if start.value == find_val:
        #         return True
        #     else:
        #         return self.preorder_search(start.left, find_val) or self.preorder_search(start.right, find_val)

        # return False

    def preorder_print(self, start, traversal):
        if (start is not self.root):
            traversal += '-{}'.format(start.value)

        if start.left is not None:
            traversal += self.preorder_print(start.left, '')

        if start.right is not None:
            traversal += self.preorder_print(start.right, '')
            
        return traversal

        # Official Answer:
        # if start:
        #     traversal += (str(start.value) + "-")
        #     traversal = self.preorder_print(start.left, traversal)
        #     traversal = self.preorder_print(start.right, traversal)
        # return traversal


# Set up tree
tree = BinaryTree(1)
tree.root.left = Node(2)
tree.root.right = Node(3)
tree.root.right.left = Node(7)
tree.root.right.right = Node(8)
tree.root.left.left = Node(4)
tree.root.left.left.right = Node(6)
tree.root.left.right = Node(5)


# Test search
# Should be True
print(tree.search(1))
print(tree.search(2))
print(tree.search(3))
print(tree.search(4))
print(tree.search(5))
# Should be False
print(tree.search(6))
print(tree.search(9))


# Test print_tree
# Should be 1-2-4-5-3
print(tree.print_tree())