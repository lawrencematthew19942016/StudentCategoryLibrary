select * from books left join book_category using (cid) order by bid;


select * from books, book_category where books.cid = book_category.cid;