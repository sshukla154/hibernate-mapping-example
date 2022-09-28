# hibernate-mapping-example

### APIs

## 
1. Documenting a Spring REST API Using OpenAPI 3.0


## Topics:
1. Mapping
    - One-To-One : E.G. Tutorial (`tutorial`) and TutorialDetails (`tutorial_details`)
      - The `@PrimaryKeyJoinColumn` tells Hibernate that the primary key for the `tutorial` table will be used as the foreign key in the owning `tutorial_details` table. The `@MapsId` tells Hibernate that the primary key on the `tutorial` table will be used as the primary key for the `tutorial_details` table. Since the primary key is being reused, we don't need to specify `@GenderatedValue` on the `tutorial_details` table.
      - Approach-1: Foreign Key Association
      - Approach-2: Join Table
      - Approach-3: MapsById
      - Approach-4: Shared PrimaryKey
    - One-To-Many : One row in a table is mapped to multiple row in another table.
      - Unidirectional: `@OneToMany` and `@JoinColumn` E.G. One post have many comments.
      - Bidirectional: `@OneToMany` and `@ManyToOne`
    - Many-To-One
    - Many-To-Many
2. States in Hibernate
3. Cache implementation in Hibernate - First and Second level cache in Hibernate
4. save(), saveOrUpdate(), and persist()
5. get() and load() 
6. Cascade Type and its use case