document.addEventListener('DOMContentLoaded', function () {
    document.querySelectorAll('.delete-form').forEach( form => {
        form.addEventListener('submit', event => {
            if (!confirm('本当に削除しますか？')) {
                event.preventDefault();
            }
        });
    });
});
