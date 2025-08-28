# 📝 Expression Tree Traversal Java

Implementasi Pohon Ekspresi dengan Traversal di Java  
Proyek Java yang membangun pohon ekspresi dari notasi infix dan menampilkan traversal prefix, infix, dan postfix menggunakan stack.

## 📖 Deskripsi Proyek
Expression_Tree_Traversal_Java adalah proyek Java yang mengimplementasikan pohon ekspresi untuk ekspresi matematika sederhana. Proyek ini berfokus pada:

- **TreeNode.java**: Kelas dasar untuk node pohon dengan data karakter, left node, dan right node, serta metode isLeaf.  
- **Tree.java**: Kelas utama untuk membangun pohon dari infix menggunakan stack, dengan metode isOperand/isOperator, dan traversal (prefix, infix, postfix).  
- **MainTree.java**: Kelas utama untuk menguji pohon dengan ekspresi "(A+B)", menampilkan traversal, dan demonstrasi stack sederhana.

Proyek ini terdiri dari tiga file Java (MainTree.java, Tree.java, TreeNode.java) dalam paket `PERTEMUAN7`.🟢

## 🧠 Teknologi
- Java

## 📂 Struktur File
```
Expression_Tree_Traversal_Java/
├── src/PERTEMUAN7/
├── MainTree.java            # 🛠️ Kelas utama untuk pengujian
├── Tree.java                # 🔍 Kelas untuk pohon ekspresi dan traversal
├── TreeNode.java            # 📊 Kelas node pohon
```

## 🟢 Catatan:
- Pohon dibangun dari ekspresi infix seperti "(A+B)" menggunakan stack untuk operand dan operator.
- Traversal menampilkan ekspresi dengan format spasi, dan infix menyertakan tanda kurung untuk non-leaf node.

## 📈 Contoh Output
MainTree.java  
```
Infix:
(A + B )
Prefix:
+ A B 
Postfix:
A B + 
```

## 👨‍💻 Pengembang
MBAHSINGO22  
🔗 GitHub
