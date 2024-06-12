-- init.sql

-- テーブルが存在しない場合は作成
CREATE TABLE IF NOT EXISTS memo (
    id SERIAL PRIMARY KEY,
    description TEXT,
    policy TEXT,
    dice_result TEXT
);

-- サンプルデータを追加
INSERT INTO memo (description, policy, dice_result)
SELECT 'サンプル課題1', 'サンプル方針1', '勝ち'
WHERE NOT EXISTS (SELECT 1 FROM memo WHERE description = 'サンプル課題1' AND policy = 'サンプル方針1');

INSERT INTO memo (description, policy, dice_result)
SELECT 'サンプル課題2', 'サンプル方針2', '負け'
WHERE NOT EXISTS (SELECT 1 FROM memo WHERE description = 'サンプル課題2' AND policy = 'サンプル方針2');