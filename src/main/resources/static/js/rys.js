$(document).ready(function ()
{
    function getBooksFromDatabase()
    {
        $.ajax(
            {
            url: "/api/v1/book/get_books",
            type: "GET",
            success: function (result)
            {
                createTable(result);
            },
            error: function (error)
            {
                alert("Error fetching books: ", error);
            }
        });
    }

    function createTable(books)
    {
        var table = $('<table></table>').addClass('book-table');
        var header = $('<tr></tr>');
        header.append($('<th></th>').text('ISBN'));
        header.append($('<th></th>').text('Title'));
        header.append($('<th></th>').text('Author'));
        header.append($('<th></th>').text('Release Date'));
        header.append($('<th></th>').text('Genre'));
        header.append($('<th></th>').text('Description'));
        header.append($('<th></th>').text('Status'));
        header.append($('<th></th>').text('Owner'));
        header.append($('<th></th>').text('Owner Email'));
        header.append($('<th></th>').text('Borrower'));
        table.append(header);

        $.each(books, function (index, book)
        {
            var row = $('<tr></tr>');
            row.append($('<td></td>').text(book.isbn));
            row.append($('<td></td>').text(book.title));
            row.append($('<td></td>').text(book.author));
            row.append($('<td></td>').text(book.releaseDate));
            row.append($('<td></td>').text(book.genre));
            row.append($('<td></td>').text(book.description));
            row.append($('<td></td>').text(book.status));
            row.append($('<td></td>').text(book.owner));
            row.append($('<td></td>').text(book.ownerEmail));
            row.append($('<td></td>').text(book.borrower));
            table.append(row);
        });

        $('#book-container').html(table);
    }

    getBooksFromDatabase();
});

