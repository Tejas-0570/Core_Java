/*
#3 Easy Enumeration — legacy iteration
-----------------------------------------------------------------------------------------------------------------------------------
Old-style inventory iteration

Populate a Vector with 10 product names. Iterate using Enumeration — the pre-Iterator way of traversing collections (Java 1.0 era).
Compare Enumeration with Iterator — show what Enumeration cannot do that Iterator can. Understand why Iterator replaced it.
-----------------------------------------------------------------------------------------------------------------------------------
⚠️ Legacy approach — Enumeration: Enumeration has only two methods — hasMoreElements() and nextElement(). It cannot remove elements
during traversal — no remove() method. It is read-only iteration. Only works with legacy classes — Vector, Hashtable, Stack.
Modern collections use Iterator.
-----------------------------------------------------------------------------------------------------------------------------------
✅ Modern replacement — Iterator / for-each: Iterator adds remove() capability during traversal. ListIterator adds bidirectional
traversal and set(). Enhanced for-each is cleanest for simple traversal. All work on ANY collection — not just legacy ones.
Always prefer these over Enumeration in new code.
-----------------------------------------------------------------------------------------------------------------------------------
Enumeration<String> e = v.elements()
while(e.hasMoreElements()) → e.nextElement()
e.remove() → compile error — not supported
Iterator alternative: it.remove() → works fine

Skills: Enumeration, elements(), hasMoreElements(), nextElement(), Enumeration vs Iterator limitations
Hint at bottom --->
 */

package Vector;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class OldStyleInventoryIteration {
    public static void main(String[] args) {
        System.out.println("------------- Enumerator ----------------");
        Vector<String> products = new Vector<>();
        for(int i = 1; i <= 10; i++){
            products.add("Product"+i);
        }
        products.add("Product-OUT-OF-STOCK");

        Enumeration<String> e = products.elements();
        while(e.hasMoreElements()){
            System.out.println(e.nextElement());
        }

        //e.remove(); ---> Not supported in Enumerator, compile time error

        System.out.println("------------- Iterator ----------------");

        Iterator<String> it = products.iterator();
        while (it.hasNext()){
            String product = it.next();
            if(product.contains("OUT")){
                it.remove();
                System.out.println("Removed: "+product);
            }
        }
        System.out.println("Remaining Products: "+products);

    }
}


/*
Enumeration implementation:
Vector<String> products = new Vector<>() — add 10 products.
Enumeration<String> e = products.elements() — get Enumeration.
while(e.hasMoreElements()) { System.out.println(e.nextElement()); }
Import: import java.util.Enumeration

Show Enumeration limitation: Try to call e.remove() — it will not compile. Show this in a comment: // e.remove(); — does not exist in Enumeration. This is the key limitation.

Three method names comparison to print as output:
Enumeration: hasMoreElements() / nextElement()
Iterator: hasNext() / next() / remove()
ListIterator: hasNext() / next() / hasPrevious() / previous() / add() / set() / remove()

Modern Iterator on same Vector:
Iterator<String> it = products.iterator() — Vector also supports Iterator since it implements List. Remove products containing "OUT" using it.remove() during traversal — show this capability that Enumeration lacks.
 */