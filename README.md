# homework8
## В классе Notes и, соответственно, в методах для Notes опущены:
- для add: privacy_view и privacy_comment
- для edit: privacy_view и privacy_comment
- для get: note_ids, offset, count, sort - исходя из названия "Возвращает список заметок, созданных пользователем" ориентировался на user_id
- для getById: owner_id, need_wiki - исходя из названия "Возвращает заметку по её id" ориентировался на note_id


 ## В классе Comments и, соответственно, в методах для Comments опущены:
 - для create: owner_id, reply_to, guid
 - для delete: вместо owner_id использовалось note_id
 - для edit: вместо owner_id использовалось note_id
 - для get: вместо owner_id использовалось note_id; sort и offset не применялись
