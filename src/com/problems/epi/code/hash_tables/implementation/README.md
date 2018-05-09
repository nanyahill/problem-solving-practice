Definition
- HashTables are data structures that associate values with keys. Users can store (put) an entry into the hashtable
by specifying a key–value pair and then can retrieve (get) the value corresponding to a particular key.
They exploit the fact that looking up an item in an array takes constant time once you have the index (i.e. the key).
A simple example of a hashtable is an array where the array index is the key and element at that index is the value.

Properties
- HashTable keys must be immutable, hashable, and comparable.
- Hash tables store data (i.e. key/value pairs) by a two-step process:
       - Hashing (i.e. using hash function): A mathematical function used to map keys to integers used for array indexing.
       - Collision Resolution: A process that deals with the situation where two or more different keys map to the same array index.
- For keys that are small integers, an array suffices as the hash table.
- For more complicated keys such as strings and large integers, the two-step process is required.
- Search, Insert and LookUp take O(1) on average.


Pointers
- HashTables are a more practical way to maintain a dictionary data structure.
- Three requirements for a good hash function:
    - deterministic: equal keys produce the same hash value.
    - efficient to compute
    - uniformly distribute the keys
- Collision Resolution
    - Separate Chaining (easiest approach): The hashtable is maintained as an array of m linkedlists. Search, Insert & Delete operations reduce to the
    corresponding problems in Linkedlists. Also, considerable amount of memory is devoted to pointers.
    - Open Addressing (common approach is Linear Probing): The hashtable is maintained as an array of elements initialized to null. When there is a collision,
    the next entry in the table is checked until an empty slot is found. In the linear probing approach, search reduces to three cases:
        - key equal to search key (i.e. search hit)
        - empty position (null key at indexed position) (i.e. search miss)
        - key not equal to search key (i.e. try next entry).
    Deletion in open addressing in general can be problematic because deletion breaks the chain of insertions, creating a lot of false search misses because
     the deleted element's position is the position for other existing elements which have been previusly inserted into subsequent positions.
     A workaround is to reinsert all the items following the hole created by the deletion.
