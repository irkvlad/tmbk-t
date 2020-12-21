--Update process card_types for entity tmbkt$TrawlApplication
update wf_proc set card_types = regexp_replace(card_types, E',tmbkt\\$TrawlApplication', '') where code in ('Endorsement','Resolution','Acquaintance','Registration')^
update wf_proc set updated_by='admin', card_types = card_types || 'tmbkt$TrawlApplication,' where code in ('Endorsement','Resolution','Acquaintance','Registration')^
