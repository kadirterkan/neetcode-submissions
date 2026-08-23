# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if (head!= None):
            head = reverse(None, head)
        return head

def reverse(old, head):
    if (head != None):
        temp = reverse(head, head.next)
        head.next = old
        return temp
    else:
        return old