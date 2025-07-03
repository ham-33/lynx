# 🏛 LynxPlugin – Minecraft 国家・陣営システム

**Lynx** は Minecraft 1.21.1（Java 21 / Folia 対応）における、**国家・陣営・思想・領土・経済**などを統合管理する多機能統治プラグインです。  
Squaremapと連携し、**リアルタイムで国家領土や首都をWeb上に可視化**することも可能です。

---

## ✨ 特徴

- ✅ **完全な国家管理機能**（建国、役職、思想、政党など）
- ✅ **陣営による国家連携・勢力構築**
- ✅ **役職階級と細かな権限設定（Rank1〜10）**
- ✅ **国庫と経済管理（入金・出金）**
- ✅ **Squaremap連携で地図上に領土・首都を表示**
- ✅ **JSONバックアップ機能 & 自動復元**
- ✅ **MySQL/MariaDBデータベース完全対応**
- ✅ **多言語対応（日本語・英語・韓国語）**
- ✅ **Folia完全対応（Java21 / RegionScheduler使用）**

---

## 🖥 動作環境

| 項目 | 内容 |
|------|------|
| Minecraft | 1.21.1 |
| Java | 21 |
| サーバー | Folia / Paper |
| データベース | MariaDB（MySQL互換） |
| マップ対応 | Squaremap 最新版 |

---

## 🗂 ディレクトリ構成（概要）

Lynx/
├── pom.xml
├── README.md
├── src/
│   └── main/
│       ├── java/
│       │   └── marvtechnology/
│       │       └── lynx/
│       │           ├── Lynx.java
│       │           ├── commands/
│       │           │   ├── CountryCommand.java
│       │           │   ├── FactionCommand.java
│       │           │   ├── BankCommand.java
│       │           │   ├── AdminCommand.java
│       │           │   └── ConfirmCommand.java
│       │           ├── listeners/
│       │           │   └── PlayerJoinListener.java
│       │           ├── country/
│       │           │   ├── Country.java
│       │           │   ├── CountryManager.java
│       │           │   ├── Rank.java
│       │           │   ├── Capital.java
│       │           │   └── Request.java
│       │           ├── faction/
│       │           │   ├── Faction.java
│       │           │   └── FactionManager.java
│       │           ├── bank/
│       │           │   └── BankManager.java
│       │           ├── map/
│       │           │   ├── MapSyncManager.java
│       │           │   └── MarkerBuilder.java
│       │           ├── db/
│       │           │   ├── DatabaseManager.java
│       │           │   └── models/
│       │           │       ├── CountryModel.java
│       │           │       ├── FactionModel.java
│       │           │       ├── MemberModel.java
│       │           │       └── ClaimModel.java
│       │           ├── backup/
│       │           │   ├── BackupManager.java
│       │           │   └── JsonExporter.java
│       │           ├── lang/
│       │           │   ├── LangManager.java
│       │           │   └── messages/
│       │           │       ├── ja.yml
│       │           │       ├── en.yml
│       │           │       └── ko.yml
│       │           └── utils/
│       │               ├── PermissionUtil.java
│       │               ├── LocationUtil.java
│       │               └── JsonUtil.java
│       └── resources/
│           ├── plugin.yml
│           ├── settings.yml
│           ├── database.yml
│           ├── permissions.yml
│           └── languages/
│               ├── ja.yml
│               ├── en.yml
│               └── ko.yml


🧭 3. 使用コマンド一覧（全カテゴリ）
🏛 国家コマンド /country
コマンド	概要
/country create <name>	国家を建国
/country delete	国家削除（OP）
/country disband	国家解体（建国者）
/country transfer <player>	建国者を譲渡（承認制）
/country invite <player>	プレイヤーを国家に招待
/country kick <player>	プレイヤーを追放
/country join <name>	国家に参加（招待制）
/country leave	国家から脱退
/country info	国家の情報表示
/country list	国家一覧を表示
/country setcapital <x> <z>	首都座標の設定
/country party set <name>	政党名の設定
/country ideology set <name>	思想名の設定
/country rank setname <rank> <name>	役職名変更
/country rank setperm <rank> <perm>	権限変更
🏳 陣営コマンド /faction
コマンド	概要
/faction create <name>	陣営作成
/faction delete	陣営削除（OP）
/faction join <name>	陣営に国家が加入
/faction leave	陣営から脱退
/faction info	陣営情報表示
/faction list	陣営一覧表示
💰 経済コマンド /country bank
コマンド	概要
/country bank info	国庫残高表示
/country bank deposit <金額>	入金
/country bank withdraw <金額>	出金（要権限）
🔧 Lynx 汎用・承認コマンド /lynx
コマンド	概要
/lynx accept	リクエストを承認
/lynx deny	リクエストを拒否
/lynx reload	設定/DBを再読み込み
/lynx syncmap	Squaremapと同期
/lynx backup	手動バックアップ実行
/lynx restore <name>	国家データを復元
/lynx listdeleted	削除済国家一覧表示
🛡 管理者コマンド /admin
コマンド	概要
/admin country delete <name>	国家削除（強制）
/admin country restore <name>	国家復元
/admin country rename <old> <new>	国家名変更
/admin country transfer <国名> <新建国者>	建国者強制譲渡
/admin country purge <国名>	国家完全削除（物理）
/admin faction delete <name>	陣営削除
/admin faction purge <name>	陣営完全削除（物理）
/admin bank set <国名> <金額>	国庫残高を設定
/admin bank add/remove <国名> <金額>	国庫に加算/減算
/admin lynxlog view/search	国家ログ検索表示
/admin lynxrequest cancel <UUID>	リクエストを強制キャンセル
