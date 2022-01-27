$(document).ready(function () {

    var table = $('#dataTable').DataTable({
        dom: 'lBfrtip',
        orderCellsTop: true,
        fixedHeader: true,
        "language": {
            "lengthMenu": "Показано _MENU_ записей на странице",
            "zeroRecords": "Ничего не найдено",
            "info": "Показаны _PAGE_ страниц из _PAGES_",
            "infoEmpty": "Ничего не найдено",
            "infoFiltered": "(Отфильтровано _MAX_ записей)",
            "search": "Поиск:",
            "paginate": {
                "first": "Первая",
                "last": "Последняя",
                "next": "Следующая",
                "previous": "Предыдущая"
            },
            "searchBuilder": {
                "add": 'Добавить фильтр',
                "button": 'Фильтры',
                "clearAll": 'Очистить',
                "condition": 'Операторы',
                "conditions": {
                    "date": {
                        "before": 'до',
                        "after": 'после',
                        "equals": 'равно',
                        "not": 'не',
                        "between": 'между',
                        "notBetween": 'не между',
                        'empty': 'пустой',
                        'notEmpty': 'не пустой'
                    },
                    "moment": {
                        'before': 'до',
                        "after": 'после',
                        "equals": 'равно',
                        "not": 'не',
                        "between": 'между',
                        "notBetween": 'не между',
                        "empty": 'пустой',
                        "notEmpty": 'не пустой'
                    },
                    "number": {
                        "before": 'до',
                        "after": 'после',
                        "equals": 'равно',
                        "not": 'не',
                        "between": 'между',
                        "notBetween": 'не между',
                        "empty": 'пустой',
                        "notEmpty": 'не пустой'
                    },
                },
                "data": 'Столбцы',
                "logicAnd": 'И',
                "logicOr": 'ИЛИ',
                "title": {
                    _: 'Фильтры (%d)'
                },
                "deleteTitle": 'Удалить',
                "value": 'Значение',
            }
        },

        scrollX: true
    });
});
