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

    function addBook(book) {
        $.ajax({
            url: '/api/v1/book/add_book',
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(book),
            success: function() {
                getBooksFromDatabase();
            },
            error: function(error) {
                alert('Error adding book:', error);
            }
        });
    }

    $('#add-book-form').on('submit', function(event) {
        event.preventDefault();
        var book = {
            isbn: $('#isbn').val(),
            title: $('#title').val(),
            author: $('#author').val(),
            releaseDate: $('#releaseDate').val(),
            genre: $('#genre').val(),
            description: $('#description').val(),
            status: $('#status').val(),
            owner: $('#owner').val(),
            borrower: $('#borrower').val(),
            ownerEmail: $('#ownerEmail').val()
        };
        addBook(book);
        $('#add-book-modal').hide();
    });

    $('#add-book-button').on('click', function() {
        $('#add-book-modal').show();
    });

    $('.close').on('click', function() {
        $('#add-book-modal').hide();
    });

    $(window).on('click', function(event) {
        if ($(event.target).is('#add-book-modal')) {
            $('#add-book-modal').hide();
        }
    });

    getBooksFromDatabase();
});

