-- Migrations to add the RANK column on the dwarf register table

ALTER TABLE tb_dwarf
ADD COLUMN rank VARCHAR(255);