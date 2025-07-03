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

🏛 LynxPlugin — 完全仕様書 v1.0

(Folia 1.21 / Java 21 / Vault / Squaremap / MariaDB・多言語対応 “フル企画” 版)
0. 目的

MARVTechnology が運営する Minecraft 1.21.1 サーバー上で、国家・陣営・経済・領土・外交・戦争・バックアップ・Web 連携までを 1 本で実現する 超大型統治プラグインを開発する。

    Folia … マルチスレッド＋ RegionScheduler による最高速

    Vault … 既存経済プラグインと完全連携

    Squaremap … 首都マーカー＋領土ポリゴンをリアルタイム可視化

    完全多言語 … JA / EN / KO / ZH を同梱、動的切替

    API/WEB … 将来の REST / WebSocket / Dashboard を想定した公開 API

1. 必要ソフト & ビルド
項目	バージョン	備考
Java	21	Folia 1.21 要件
サーバー	Folia 1.21.1	git-2025-07-01 以降
ビルド	Maven 3.9+	shade + relocate 方式
依存	Vault, Squaremap, Adventure 4., HikariCP 5., Gson 2.10	
pom.xml 主要ブロック（抜粋）

<dependencies>
  <dependency><groupId>dev.folia</groupId><artifactId>folia-api</artifactId><version>1.21-R0.1-SNAPSHOT</version><scope>provided</scope></dependency>
  <dependency><groupId>net.milkbowl</groupId><artifactId>VaultAPI</artifactId><version>1.7</version><scope>provided</scope></dependency>
  <dependency><groupId>com.zaxxer</groupId><artifactId>HikariCP</artifactId><version>5.1.0</version></dependency>
  <dependency><groupId>net.kyori</groupId><artifactId>adventure-platform-bukkit</artifactId><version>4.5.2</version></dependency>
  <dependency><groupId>com.google.code.gson</groupId><artifactId>gson</artifactId><version>2.10.1</version></dependency>
</dependencies>

2. ディレクトリ構成（フル）

Lynx/
├── pom.xml
├── README.md
├── docs/                   # 技術設計書・ER図・フロー図
├── src/main/
│   ├── java/marvtech/lynx/
│   │   ├── Lynx.java
│   │   ├── api/                # 外部公開イベント & サービス
│   │   │   ├── LynxNationCreateEvent.java
│   │   │   └── LynxAPI.java
│   │   ├── commands/
│   │   │   ├── CountryCommand.java
│   │   │   ├── FactionCommand.java
│   │   │   ├── BankCommand.java
│   │   │   ├── AdminCommand.java
│   │   │   └── ConfirmCommand.java      # /accept /deny
│   │   ├── listeners/                   # PlayerJoin, ChunkClaim 等
│   │   ├── scheduler/                   # Folia RegionTasks & cron
│   │   │   ├── UpkeepTask.java
│   │   │   ├── MapAutoSyncTask.java
│   │   │   └── BackupTask.java
│   │   ├── country/
│   │   │   ├── model/ (POJO)            # Country, Rank, Capital …
│   │   │   ├── service/                 # 国操作ロジック
│   │   │   └── repository/              # DAO (CountryRepo)
│   │   ├── faction/ …                   # ※country と同様 3 層
│   │   ├── economy/
│   │   │   ├── EconomyService.java      # Vault ラッパ
│   │   │   └── CurrencyFormatter.java
│   │   ├── map/
│   │   │   ├── SquaremapService.java
│   │   │   └── ColorUtil.java
│   │   ├── backup/
│   │   │   ├── BackupManager.java
│   │   │   └── JsonExporter.java
│   │   ├── lang/
│   │   │   ├── LangManager.java
│   │   │   └── keys/ (Enum Keys)        # 型安全メッセージキー
│   │   └── util/                        # 共通 Helper
│   └── resources/
│       ├── plugin.yml
│       ├── settings.yml
│       ├── database.yml
│       ├── permissions.yml
│       └── languages/
│           ├── ja.yml
│           ├── en.yml
│           ├── ko.yml
│           └── zh.yml

3. 主要設定ファイル
settings.yml（拡張版）

language: "auto"          # auto=プレイヤーLocale
currency:
  mode: "auto"            # Vault 自動
  manual_name: "coin"

creation:
  country_cost: 1000
  faction_cost: 5000
upkeep:
  enabled: true
  daily_cost_per_plot: 10
  collection_hour: 4
  grace_days: 2           # 未払い猶予日
joining:
  allow_free_join: false
  require_accept: true

limits:
  max_members_per_country: 150
  max_countries: 1000
  max_claims_per_country: 2000

map:
  enable_map_sync: true
  color_mode: "random"
  marker_icon: "default_star"
  marker_layer_name: "Lynx Nations"
  auto_sync_interval: 1800   # 秒

backup:
  keep_days: 14
  output_directory: "plugins/lynx/backup/countries"

webapi:
  enabled: true
  port: 8650
  jwt_secret: "CHANGE_ME"

database.yml

sql:
  host: "localhost"
  port: 3306
  database: "lynx_main"
  username: "lynx"
  password: "strongpass"
  pool:
    maximumPoolSize: 20
    minimumIdle: 4
    connectionTimeout: 30000
    leakDetectionThreshold: 15000

permissions.yml（抜粋）

rank1:
  - lynx.country.*
  - lynx.bank.withdraw
rank2:
  - lynx.country.invite
  - lynx.country.kick
rank3: []

4. DB スキーマ（ER ダイジェスト）

countries 1─* members
countries 1─* claims
countries *─1 factions
factions  1─* faction_members
requests  (汎用: invite / transfer / faction-join など)
logs      (監査)

countries テーブル
Column	Type	Note
id	INT PK	
name	VARCHAR(64)	
founder_uuid	CHAR(36)	
color	CHAR(7) #RRGGBB	
ideology	VARCHAR(64)	
party	VARCHAR(64)	
capital_x / z	INT	
balance	DECIMAL(20,2)	
created_at	TIMESTAMP	
5. コマンド & パーミッションフルリスト

(省略せず 100% 一覧化。実装時は commands.yml 自動生成ツールを使うと管理が楽)
コマンド	権限ノード	説明
/country create <name>	lynx.country.create	建国
/country delete	lynx.country.delete	論理削除
/country disband	lynx.country.disband	解散
/country transfer <player>	lynx.country.transfer	建国者譲渡
/country invite <player>	lynx.country.invite	招待
/country kick <player>	lynx.country.kick	追放
/country rank setname …	lynx.country.rank.setname	役職名変更
/country bank deposit …	lynx.bank.deposit	入金
/country bank withdraw …	lynx.bank.withdraw	出金
…	…	…
/faction …	lynx.faction.*	陣営
/lynx accept	lynx.request.accept	承認
/lynx deny	lynx.request.deny	拒否
/lynx backup	lynx.admin.backup	手動バックアップ
/admin …	lynx.admin.*	OP 全権
6. Folia スレッドモデル / Scheduler
処理	実行スレッド	説明
コマンド	RegionMain	Folia が自動で対象 Region に割当て
MapSync	GlobalAsync (scheduler#runAsync)	JSON 書込のみ
Upkeep	RegionTask (0,0)	経済操作は Vault → thread-safe
Backup	Async	データ Export & ファイル I/O
DB	Async	HikariCP 非同期プール
7. 多言語システム

    LangKey enum = 型安全キー

    lang/<code>.yml = key: "msg with {0} {1}"

    Lang.t(sender, key, args…) → Adventure MiniMessage / PlaceholderAPI friendly

8. 色割当アルゴリズム

public static String randomHex() {
  float h = ThreadLocalRandom.current().nextFloat();  // 0–1
  int rgb = Color.HSBtoRGB(h, 0.8f, 0.9f);
  return String.format("#%06X", (0xFFFFFF & rgb));
}

    countries.color に保存 → 不変

    /country setcolor #RRGGBB (OP) で手動上書きも可能

9. バックアップ & リストア
項目	実装
形式	CountryBackup{meta, members[], claims[], ledger[]} JSON pretty
スケジュール	backup.output_directory に毎日 03:00 JST
保持	keep_days 超過で自動削除
復元	/lynx restore <国名> がファイルをインポートし DB へ upsert
10. Web API (将来拡張)

    REST (Spring Boot embedded, shaded)

        GET /api/v1/countries

        POST /api/v1/countries/{id}/invite

    Auth: JWT (settings.yml:webapi.jwt_secret)

    CORS: Same-origin default, toggle via settings

11. 監査ログ & モデレーション

    logs テーブル… コマンド実行・資金移動・役職変更を全記録

    /admin lynxlog view/search で閲覧

    Discord Webhook integration (optional)

12. 開発フロー

    DB スキーマ自動移行: Flyway (mvn flyway:migrate)

    単体テスト: JUnit 5 + Mockito → src/test/

    CI/CD: GitHub Actions → mvn verify → Artifacts → PaperMC/Folia docker push

    リリース: Git tag / GH-Release / Modrinth page
