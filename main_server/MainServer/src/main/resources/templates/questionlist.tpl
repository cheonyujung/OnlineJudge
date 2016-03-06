layout 'test.tpl', title: '질문게시판',
        content: contents {
            div(class: 'container') {
                div(class: 'prob-nav') {
                    ul(){
                        li(){
                            a(href : '/notice', '공지사항')
                        }
                        li(){
                            a(href : '/question', 'Q&A')
                        }
                    }
                    form(id: 'search-form', action = '', method = 'post') {
                        input(type: 'text', value: '', name: 'search')
                        input(type: 'button', value: '검색')
                    }
                }
            }
            div(class: 'prob-container') {
                table(class: 'prob-table') {
                     thead {
                          tr {
                              td '번호'
                              td '제목'
                              td '문제'
                              td '작성자'
                              td '날짜'
                          }
                     }
                     tbody {
                         if (messages.empty) {
                              tr { td(colspan: '6', 'No Problem') }
                              } else {
                                   messages.each { message ->
                                   tr {
                                       td message.number
                                       td {
                                        a(href : '/notice/message.id', message.title)
                                       }
                                       td message.quest
                                       td message.user
                                       td message.date
                                   }
                              }
                         }
                     }
                }
            }
        }