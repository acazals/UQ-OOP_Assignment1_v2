package examblock.inputs;

import examblock.model.Exam;
import examblock.model.ExamList;
import examblock.model.Room;
import examblock.model.RoomList;
import examblock.model.Student;
import examblock.model.StudentList;
import examblock.model.Subject;
import examblock.model.SubjectList;
import examblock.model.Unit;
import examblock.model.UnitList;
import examblock.model.Venue;
import examblock.model.VenueList;

/**
 * Assignment 1 (only) - pre-loads the data for Assignment 1 - not used for A2.
 * Pre-loads all the possible subjects and subject units.
 * Also pre-loads the entire cohort of Year 12 Students, all the Exams for this block,
 * all the rooms and all the venues.
 * <p>
 * These are some really ugly hacks to load up all the data and save you time.
 * This is NOT good programming style and you will fix this in Assignment 2,
 * but leave it as it is for Assignment 1.
 * </p>
 * <p>
 * DO NOT MODIFY THIS FOR ASSIGNMENT 1
 * </p>
 */
public class Catalogue {

    private final SubjectList subjectCatalogue; // All possible subjects in this block.
    private final UnitList unitCatalogue; // All possible subject units in this block.
    private final StudentList cohort; // All the Year 12 students.
    private final ExamList exams; // The current set of Year 12 Exams.
    private final RoomList rooms; // The current set of available rooms.
    private final VenueList venues; // The current set of exam venues.

    /**
     * Instantiates an instance of Catalogue.
     */
    public Catalogue() {
        subjectCatalogue = new SubjectList(); // All the possible subjects.
        unitCatalogue = new UnitList(); // All the possible subject units.
        cohort = new StudentList(); // All the Year 12 Students.
        exams = new ExamList(); // All the exams in this block.
        rooms = new RoomList(); // All the rooms.
        venues = new VenueList(); // All the exam venues.

        populateCatalogues(); // Load up all the subjects and units.
        populateCohort(); // Load up all the Year 12 Students.
        populateExams(); // Load up the current set of Year 12 Exams.
        populateRooms(); // Load up all the rooms and exam venues.
    }

    /**
     * Gets the {@code subjectCatalogue} associated with this {@code Catalogue}.
     *
     * @return the reference to the unitCatalogue
     */
    public SubjectList subjects() {
        return subjectCatalogue;
    }

    /**
     * Gets the {@code unitCatalogue} associated with this {@code Catalogue}.
     *
     * @return the reference to the unitCatalogue
     */
    public UnitList units() {
        return unitCatalogue;
    }

    /**
     * Gets the {@code cohort} associated with this {@code Catalogue}.
     *
     * @return the reference to the cohort
     */
    public StudentList cohort() {
        return cohort;
    }

    /**
     * Gets the list of {@code exams} associated with this exam block.
     *
     * @return the reference to the exams
     */
    public ExamList exams() {
        return exams;
    }

    /**
     * Gets the list of {@code rooms} associated with this exam block.
     *
     * @return the reference to the rooms
     */
    public RoomList rooms() {
        return rooms;
    }

    /**
     * Gets the list of {@code venues} associated with this exam block.
     *
     * @return the reference to the venues
     */
    public VenueList venues() {
        return venues;
    }

    /**
     * Load up all the possible subjects.
     */
    private void populateCatalogues() {
        Subject subject = new Subject("Accounting",
                "The study of the management of financial resources " +
                        "of the public sector, businesses, and individuals.");
        subjectCatalogue.addSubject(subject);
        Unit unit = new Unit(subject, '3', "Managing resources",
                "Manage the resources of a sole trader business including " +
                        "cash, accounts receivable, non-current assets and technology.");
        unitCatalogue.addUnit(unit);
        unit = new Unit(subject, '4', "Accounting — the big picture",
                "The complete process of preparing fully classified " +
                        "financial statements for a sole trader business, and an " +
                        "analysis and evaluation of the Statement of Profit or Loss, " +
                        "Statement of Financial Position and Statement of Cash Flows.");
        unitCatalogue.addUnit(unit);
        subject = new Subject("Ancient History",
                "The study of people, societies and civilisations of " +
                        "the Ancient World, from the development of the earliest " +
                        "human communities to the end of the Middle Ages.");
        subjectCatalogue.addSubject(subject);
        unit = new Unit(subject, '3', "Reconstructing the Ancient World",
                "Investigate significant historical periods through an " +
                        "analysis of relevant archaeological and written sources.");
        unitCatalogue.addUnit(unit);
        unit = new Unit(subject, '4', "People, power and authority",
                "Investigate an important historical period, " +
                        "with a particular emphasis on the nature and exercise " +
                        "of power and authority.");
        unitCatalogue.addUnit(unit);
        subject = new Subject("Biology",
                "The study of living systems.");
        subjectCatalogue.addSubject(subject);
        unit = new Unit(subject, '3',
                "Biodiversity and the interconnectedness of life",
                "Biodiversity within ecosystems; biotic and abiotic; " +
                        "species interactions; adaptations of organisms " +
                        "population dynamics; and classification systems.");
        unitCatalogue.addUnit(unit);
        unit = new Unit(subject, '4', "Heredity and continuity of life",
                "The cellular processes and mechanisms that ensure the " +
                        "continuity of life.");
        unitCatalogue.addUnit(unit);
        subject = new Subject("Business",
                "Investigations of business situations, using a variety " +
                        "of analytical tools to comprehend, analyse and interpret " +
                        "business data and information; and to evaluate strategies " +
                        "using business criteria.");
        subjectCatalogue.addSubject(subject);
        unit = new Unit(subject, '3', "Business diversification",
                "Businesses in the maturity stage of the business life " +
                        "cycle, investigating diversification strategies, with a " +
                        "specific focus on expansion into global markets and " +
                        "emerging strategies providing a competitive advantage.");
        unitCatalogue.addUnit(unit);
        unit = new Unit(subject, '4', "Business evolution",
                "Challenges for businesses in the post-maturity stage of " +
                        "the business life cycle and explore the leadership and " +
                        "management required when repositioning or transforming a " +
                        "business using financial, human resources, marketing and " +
                        "operational management strategies.");
        unitCatalogue.addUnit(unit);
        subject = new Subject("Chemistry",
                "The study of materials and their properties and structure.");
        subjectCatalogue.addSubject(subject);
        unit = new Unit(subject, '3', "Equilibrium, acids and redox reactions",
                "The reversibility of reactions in a variety of chemical " +
                        "systems at different scales; acid-base equilibrium systems " +
                        "and their applications; the principles of oxidation and " +
                        "reduction reactions; and the production of electricity " +
                        "from electrochemical cells.");
        unitCatalogue.addUnit(unit);
        unit = new Unit(subject, '4', "Structure, synthesis and design",
                "The ways in which models and theories relate to chemical " +
                        "synthesis, structure and design, and associated applications; " +
                        "the current and future uses of  resources, focussing on " +
                        "chemical synthesis, particularly in organic chemistry, and " +
                        "consider where and how functional groups can be incorporated " +
                        "into already existing carbon compounds in order to generate " +
                        "new substances; and future applications of chemistry to " +
                        "synthesise new substances, such as pharmaceuticals, fuels, " +
                        "polymers and nanomaterials.");
        unitCatalogue.addUnit(unit);
        subject = new Subject("Design",
                "The application of design thinking to envisage creative " +
                        "products, services and environments.");
        subjectCatalogue.addSubject(subject);
        unit = new Unit(subject, '3', "Human-centred design",
                "Use designing with empathy as an approach to define " +
                        "problems by understanding and experiencing the needs and " +
                        "wants of a stakeholder.");
        unitCatalogue.addUnit(unit);
        unit = new Unit(subject, '4', "Sustainable design influences",
                "How designers identify design opportunities without " +
                        "working from needs and wants provided by stakeholders. " +
                        "This unit explores how stakeholders are encouraged to " +
                        "accept a designed solution they did not realise they needed. " +
                        "Students identify and explore opportunities to design " +
                        "products, services or environments to improve their " +
                        "sustainability.");
        unitCatalogue.addUnit(unit);
        subject = new Subject("Digital Solutions",
                "Students learn about algorithms, computer languages and " +
                        "user interfaces through generating digital solutions to " +
                        "problems.");
        subjectCatalogue.addSubject(subject);
        unit = new Unit(subject, '3', "Digital innovation",
                "Analyse end-user needs, determine data, programming and " +
                        "user experience requirements, using available resources " +
                        "to generate components and prototyped digital solutions.");
        unitCatalogue.addUnit(unit);
        unit = new Unit(subject, '4', "Digital impacts",
                "how digital solutions are required to exchange data " +
                        "securely and efficiently; elements of cybersecurity; the " +
                        "conditions, environment and methods for enabling data to " +
                        "flow between different digital systems; analyse data privacy " +
                        "and data integrity risks associated with transferring data " +
                        "and evaluate the personal, social and economic impacts " +
                        "associated with the use and availability of both public and " +
                        "private data.");
        unitCatalogue.addUnit(unit);
        subject = new Subject("Drama",
                "Investigating, communicating and embodying stories, " +
                        "experiences, emotions and ideas that reflect the human " +
                        "experience.");
        subjectCatalogue.addSubject(subject);
        unit = new Unit(subject, '3', "Challenge",
                "Investigate dramatic styles that are united by social " +
                        "commentary, and that question their world and advocate change.");
        unitCatalogue.addUnit(unit);
        unit = new Unit(subject, '4', "Transform",
                "Manipulating and shaping the dramatic languages to reframe " +
                        "text, purpose, context and meaning, drawing on stylistic " +
                        "characteristics and philosophies of contemporary performance.");
        unitCatalogue.addUnit(unit);
        subject = new Subject("Economics",
                "Microeconomics being the study of individuals, households " +
                        "and businesses; and macroeconomics, the study of economy-" +
                        "wide phenomena.");
        subjectCatalogue.addSubject(subject);
        unit = new Unit(subject, '3', "International economics",
                "The complex ideas and relationships underlying the " +
                        "international economy and the impact that these have on " +
                        "Australia’s domestic economy and decision-making.");
        unitCatalogue.addUnit(unit);
        unit = new Unit(subject, '4', "Contemporary macroeconomics",
                "The practical application of the Australian Government’s " +
                        "domestic macroeconomic objectives.");
        unitCatalogue.addUnit(unit);
        subject = new Subject("Engineering",
                "The practical application of science, technology, " +
                        "engineering and mathematics (STEM) knowledge to develop " +
                        "sustainable products, processes and services.");
        subjectCatalogue.addSubject(subject);
        unit = new Unit(subject, '3', "Civil structures",
                "Individual and collaborative group activities, material and " +
                        "process testing, analysis of the forces on structures; " +
                        "engineering solutions for environmental extremes, including " +
                        "intense cold and heat, storms, drought or flood.");
        unitCatalogue.addUnit(unit);
        unit = new Unit(subject, '4', "Machines and mechanisms",
                "Understanding dynamics through machines and mechanisms, " +
                        "including the uniformly accelerated motion of objects " +
                        "in one dimension, apparent weight, and motion on an " +
                        "inclined plane.");
        unitCatalogue.addUnit(unit);
        subject = new Subject("English",
                "The study of both literary texts and non-literary texts, " +
                        "developing students as independent, innovative and creative " +
                        "learners and thinkers who appreciate the aesthetic use of " +
                        "language, analyse perspectives and evidence, and challenge " +
                        "ideas and interpretations through the analysis and creation " +
                        "of varied texts.");
        subjectCatalogue.addSubject(subject);
        unit = new Unit(subject, '3', "Textual connections",
                "Explore connections between texts by examining " +
                        "representations of the same concepts and issues in " +
                        "different texts.");
        unitCatalogue.addUnit(unit);
        unit = new Unit(subject, '4', "Close study of literary texts",
                "Explore the world and human experience by engaging with " +
                        "literary texts from diverse times and places.");
        unitCatalogue.addUnit(unit);
        subject = new Subject("Essential English",
                "Develops and refines students’ understanding of language, " +
                        "literature and literacy to enable them to interact confidently " +
                        "and effectively in everyday, community and social contexts.");
        subjectCatalogue.addSubject(subject);
        unit = new Unit(subject, '3', "Language that influences",
                "Explore community, local and/or global issues and ideas " +
                        "presented in a range of texts that invite an audience to " +
                        "take up positions.");
        unitCatalogue.addUnit(unit);
        unit = new Unit(subject, '4', "Representations and popular culture texts",
                "Explore how the text structures, language features and " +
                        "language of contemporary popular culture texts shape meaning.");
        unitCatalogue.addUnit(unit);
        subject = new Subject("Literature",
                "The study of literary texts, developing students as " +
                        "independent, innovative and creative learners and thinkers " +
                        "who appreciate the aesthetic use of language, analyse " +
                        "perspectives and evidence, and challenge ideas and " +
                        "interpretations through the analysis and creation of " +
                        "varied literary texts.");
        subjectCatalogue.addSubject(subject);
        unit = new Unit(subject, '3', "Literature and identity",
                "Develop knowledge and understanding of the relationship " +
                        "between language, culture and identity in literary texts.");
        unitCatalogue.addUnit(unit);
        unit = new Unit(subject, '4', "Independent explorations",
                "Demonstrate increasing independence in exploring, " +
                        "interpreting, analysing and appreciating the aesthetic " +
                        "appeal of literary texts and the insights they offer.");
        unitCatalogue.addUnit(unit);
        subject = new Subject("English and Literature Extension",
                "The English & Literature Extension course offers more " +
                        "challenge than other English courses and builds on the " +
                        "literature study students have already undertaken. " +
                        "In Year 12, students undertake Units 3 and 4 of English " +
                        "& Literature Extension concurrently with, or after, " +
                        "Units 3 and 4 of English and/or Units 3 and 4 of Literature.");
        subjectCatalogue.addSubject(subject);
        unit = new Unit(subject, '3', "Ways of reading",
                "Engage with various interpretive practices generated from " +
                        "a range of theoretical understandings about how meaning is made.");
        unitCatalogue.addUnit(unit);
        unit = new Unit(subject, '4', "Exploration and evaluation",
                "Consists of two areas of study: Extended academic " +
                        "research paper and theorised exploration of texts.");
        unitCatalogue.addUnit(unit);
        subject = new Subject("Food and Nutrition",
                "The study of food in the context of food science, " +
                        "nutrition and food technologies.");
        subjectCatalogue.addSubject(subject);
        unit = new Unit(subject, '3', "Food science of carbohydrate and fat",
                "Study the fundamentals of food science through practical " +
                        "investigation of the nutritional, scientific and sensory " +
                        "properties of carbohydrate- and fat-based food products.");
        unitCatalogue.addUnit(unit);
        unit = new Unit(subject, '4',
                "Food solution development for nutrition consumer markets",
                "Use the problem-solving process to solve food and " +
                        "nutrition problems to improve safety, nutrition, " +
                        "convenience, transparency and accessibility for " +
                        "nutrition consumer markets.");
        unitCatalogue.addUnit(unit);
        subject = new Subject("Geography",
                "The significance of ‘place’ and ‘space’ in understanding " +
                        "our world, with the concepts of environment, interconnection, " +
                        "sustainability, scale and change building on this foundation.");
        subjectCatalogue.addSubject(subject);
        unit = new Unit(subject, '3',
                "Responding to land cover transformations",
                "Develop an understanding of changes to the biophysical " +
                        "environment over time, with a particular focus on land " +
                        "cover transformation and climate change.");
        unitCatalogue.addUnit(unit);
        unit = new Unit(subject, '4', "Managing population change",
                "Develop an understanding of population change, movement " +
                        "and distribution over space and time, and how governments, " +
                        "organisations and individuals respond to the challenges " +
                        "posed by demographic change.");
        unitCatalogue.addUnit(unit);
        subject = new Subject("German",
                "Communicating with people from German-speaking communities.");
        subjectCatalogue.addSubject(subject);
        unit = new Unit(subject, '3',
                "Unsere Gesellschaft; Kultur und Identität — " +
                        "Our society; culture and identity",
                "Groups in the community and how identity is linked or " +
                        "challenged by membership of these groups; also explore the " +
                        "role of the arts as a contributor to the formation of " +
                        "culture and identity, and how sporting and leisure " +
                        "activities both reflect and shape our lifestyle.");
        unitCatalogue.addUnit(unit);
        unit = new Unit(subject, '4',
                "Meine Gegenwart; meine Zukunft — My present; my future",
                "Opportunities to use complex German and to explore " +
                        "perspectives on issues relevant to their futures and to " +
                        "the futures of their peers, and to consider the role of " +
                        "German in their future lives.");
        unitCatalogue.addUnit(unit);
        subject = new Subject("Industrial Technology Skills",
                "Develop the knowledge, understanding and skills " +
                        "associated with traditional and contemporary tools and " +
                        "materials used by Australian manufacturing industries to " +
                        "produce products.");
        subjectCatalogue.addSubject(subject);
        unit = new Unit(subject, 'A',
                "Site preparation and foundations (Building & Construction Skills)",
                "Information and subject matter in the Building & Construction " +
                        "Skills 2024 Applied senior syllabus.");
        unitCatalogue.addUnit(unit);
        unit = new Unit(subject, 'B',
                "Framing and cladding (Building & Construction Skills)",
                "Information and subject matter in the Building & Construction " +
                        "Skills 2024 Applied senior syllabus.");
        unitCatalogue.addUnit(unit);
        unit = new Unit(subject, 'C',
                "Fixing and finishing (Building & Construction Skills)",
                "Information and subject matter in the Building & Construction " +
                        "Skills 2024 Applied senior syllabus.");
        unitCatalogue.addUnit(unit);
        unit = new Unit(subject, 'D',
                "Construction in the domestic building industry (Building & Construction Skills)",
                "Information and subject matter in the Building & Construction " +
                        "Skills 2024 Applied senior syllabus.");
        unitCatalogue.addUnit(unit);
        subject = new Subject("Japanese",
                "Communicating with people from Japanese-speaking communities.");
        subjectCatalogue.addSubject(subject);
        unit = new Unit(subject, '3',
                "Our society; culture and identity",
                "Groups in the community and how identity is linked or " +
                        "challenged by membership of these groups; also explore the " +
                        "role of the arts as a contributor to the formation of " +
                        "culture and identity, and how sporting and leisure " +
                        "activities both reflect and shape our lifestyle.");
        unitCatalogue.addUnit(unit);
        unit = new Unit(subject, '4',
                "My present; my future",
                "Opportunities to use complex Japanese and to explore " +
                        "perspectives on issues relevant to their futures and to " +
                        "the futures of their peers, and to consider the role of " +
                        "Japanese in their future lives.");
        unitCatalogue.addUnit(unit);
        subject = new Subject("Legal Studies",
                "The interaction between society and the discipline of law.");
        subjectCatalogue.addSubject(subject);
        unit = new Unit(subject, '3', "Law, governance and change",
                "The complexities of the Australian legal system and its " +
                        "capacity to deal with the diversity of competing needs; " +
                        "the role of legal institutions and law-making bodies in " +
                        "creating laws that reflect the views of society; the range " +
                        "of forces that create catalysts for change and reform, and " +
                        "how laws are changed or reformed to reflect shifting " +
                        "societal demands.");
        unitCatalogue.addUnit(unit);
        unit = new Unit(subject, '4', "Human rights in legal contexts",
                "How human rights create challenges in national and " +
                        "international contexts, including for minority groups, and " +
                        "examine Australia’s legal response to international law and " +
                        "human rights.");
        unitCatalogue.addUnit(unit);
        subject = new Subject("Essential Mathematics",
                "The major domains of mathematics in Essential Mathematics " +
                        "are Number, Data, Location and time, Measurement and Finance. " +
                        "Teaching and learning builds on the proficiency strands of " +
                        "the P–10 Australian Curriculum.");
        subjectCatalogue.addSubject(subject);
        unit = new Unit(subject, '3', "Measurement, scales and chance",
                "Develop the mathematical understandings and skills to " +
                        "solve problems relating to: Calculations, Measurement, " +
                        "Scales, plans and models, and Probability and relative " +
                        "frequencies.");
        unitCatalogue.addUnit(unit);
        unit = new Unit(subject, '4', "Graphs, data and loans",
                "Develop the mathematical understandings and skills to " +
                        "solve problems relating to: Calculations, Bivariate graphs, " +
                        "Summarising and comparing data, and Loans and compound interest.");
        unitCatalogue.addUnit(unit);
        subject = new Subject("General Mathematics",
                "General Mathematics is designed for students who want " +
                        "to extend their mathematical skills beyond Year 10 but " +
                        "whose future studies or employment pathways do not require " +
                        "calculus.");
        subjectCatalogue.addSubject(subject);
        unit = new Unit(subject, '3',
                "Bivariate data and time series analysis, sequences and Earth geometry",
                "Develop the mathematical understandings and skills to " +
                        "solve problems relating to: Bivariate data analysis 1, " +
                        "Bivariate data analysis 2, Time series analysis, Growth " +
                        "and decay in sequences, and Earth geometry and time zones.");
        unitCatalogue.addUnit(unit);
        unit = new Unit(subject, '4', "Investing and networking",
                "Develop the mathematical understandings and skills to " +
                        "solve problems relating to: Loans, investments and annuities " +
                        "1, Loans, investments and annuities 2, Graphs and networks, " +
                        "Networks and decision mathematics 1, Networks and decision " +
                        "mathematics 2.");
        unitCatalogue.addUnit(unit);
        subject = new Subject("Mathematical Methods",
                "The major domains of mathematics in Mathematical Methods " +
                        "are Algebra, Functions, relations and their graphs, Calculus " +
                        "and Statistics, with increasing levels of sophistication, " +
                        "complexity and connection.");
        subjectCatalogue.addSubject(subject);
        unit = new Unit(subject, '3',
                "Further calculus and introduction to statistics",
                "Develop the mathematical understandings and skills to " +
                        "solve problems relating to: Differentiation of exponential " +
                        "and logarithmic functions, Differentiation of trigonometric " +
                        "functions and differentiation rules, Further applications " +
                        "of differentiation, Introduction to integration, and " +
                        "Discrete random variables.");
        unitCatalogue.addUnit(unit);
        unit = new Unit(subject, '4',
                "Further calculus, trigonometry and statistics",
                "Develop the mathematical understandings and skills to " +
                        "solve problems relating to: Further integration, Trigonometry, " +
                        "Continuous random variables and the normal distribution, " +
                        "Sampling and proportions, and Interval estimates for proportions.");
        unitCatalogue.addUnit(unit);
        subject = new Subject("Specialist Mathematics",
                "The major domains of mathematical knowledge in Specialist " +
                        "Mathematics are Vectors and matrices, Real and complex " +
                        "numbers, Trigonometry, Statistics and Calculus.");
        subjectCatalogue.addSubject(subject);
        unit = new Unit(subject, '3',
                "Further complex numbers, proof, vectors and matrices",
                "Develop the mathematical understandings and skills to " +
                        "solve problems relating to:  Further complex numbers, " +
                        "Mathematical induction and trigonometric proofs, " +
                        "Vectors in two and three dimensions, Vector calculus, " +
                        "and Further matrices.");
        unitCatalogue.addUnit(unit);
        unit = new Unit(subject, '4',
                "Further calculus and statistical inference",
                "Develop the mathematical understandings and skills to " +
                        "solve problems relating to: Integration techniques, " +
                        "Applications of integral calculus, Rates of change and " +
                        "differential equations, Modelling motion, and " +
                        "Statistical inference.");
        unitCatalogue.addUnit(unit);
        subject = new Subject("Modern History",
                "Examine traces of humanity’s recent past so students may " +
                        "form their own views about the Modern World since 1750.");
        subjectCatalogue.addSubject(subject);
        unit = new Unit(subject, '3',
                "National experiences in the Modern World",
                "Develop knowledge and understanding about national " +
                        "experiences that have emerged in the Modern World.");
        unitCatalogue.addUnit(unit);
        unit = new Unit(subject, '4',
                "International experiences in the Modern World",
                "Develop knowledge and understanding about international " +
                        "experiences that have emerged in the Modern World.");
        unitCatalogue.addUnit(unit);
        subject = new Subject("Music",
                "Music is a unique art form that uses sound and silence " +
                        "as a means of personal expression.");
        subjectCatalogue.addSubject(subject);
        unit = new Unit(subject, '3', "Innovations",
                "Make and respond to music that demonstrates innovative " +
                        "use of music elements and concepts, and compositional " +
                        "devices, and learn about how these ideas are used to " +
                        "communicate new meanings.");
        unitCatalogue.addUnit(unit);
        unit = new Unit(subject, '4', "Narratives",
                "Students focus on their emerging voice and style through " +
                        "making and responding to music.");
        unitCatalogue.addUnit(unit);
        subject = new Subject("Philosophy and Reason",
                "Philosophy & Reason combines the discipline of philosophy " +
                        "with the associated methodology of critical reasoning and logic.");
        subjectCatalogue.addSubject(subject);
        unit = new Unit(subject, '3',
                "Moral philosophy and schools of thought",
                "Investigate how moral issues can be understood and " +
                        "engaged with through a rational framework.");
        unitCatalogue.addUnit(unit);
        unit = new Unit(subject, '4', "Social and political philosophy",
                "The nature of rights, including the potential source and " +
                        "scope of particular rights’ claims.");
        unitCatalogue.addUnit(unit);
        subject = new Subject("Physical Education",
                "The knowledge, understanding and skills to explore and " +
                        "enhance health and physical activity in diverse and " +
                        "changing contexts.");
        subjectCatalogue.addSubject(subject);
        unit = new Unit(subject, '3',
                "Tactical awareness and ethics in physical activity",
                "Recognise and explain the concepts and principles about " +
                        "dynamic systems of motor learning and tactical awareness " +
                        "through purposeful and authentic learning about and in " +
                        "selected physical activity; and recognise and explain the " +
                        "concepts and principles about ethics and integrity in " +
                        "physical activity");
        unitCatalogue.addUnit(unit);
        unit = new Unit(subject, '4',
                "Energy, fitness and training in physical activity",
                "Engage with concepts, principles and strategies about " +
                        "energy, fitness, training and physical activity.");
        unitCatalogue.addUnit(unit);
        subject = new Subject("Physics",
                "The inquiry into the nature of the universe.");
        subjectCatalogue.addSubject(subject);
        unit = new Unit(subject, '3', "Gravity and electromagnetism",
                "Understanding motion and its causes by using Newton’s " +
                        "laws of motion and the gravitational field model to " +
                        "analyse motion on inclined planes, and the motion of " +
                        "projectiles and satellites.");
        unitCatalogue.addUnit(unit);
        unit = new Unit(subject, '4', "Revolutions in modern physics",
                "Observations of relative motion, light and matter that " +
                        "could not be explained by classical physics theories, and " +
                        "investigate how the shortcomings of existing theories led " +
                        "to the development of the special theory of relativity and " +
                        "the quantum theory of light and matter.");
        unitCatalogue.addUnit(unit);
        subject = new Subject("Psychology",
                "Engage with concepts that explain behaviours and " +
                        "underlying cognitions.");
        subjectCatalogue.addSubject(subject);
        unit = new Unit(subject, '3', "Individual thinking",
                "Explore the ways psychology is used to describe and " +
                        "explain the role of the human nervous system in individual " +
                        "thinking, and the cognitive processes involved in perception, " +
                        "memory, and learning.");
        unitCatalogue.addUnit(unit);
        unit = new Unit(subject, '4', "The influence of others",
                "Explore the ways Psychology is used to describe and " +
                        "explain how others influence our development, behaviour " +
                        "and thinking.");
        unitCatalogue.addUnit(unit);
        subject = new Subject("Spanish",
                "Communicating with people from Spanish-speaking communities.");
        subjectCatalogue.addSubject(subject);
        unit = new Unit(subject, '3',
                "Nuestra sociedad; cultura e identidad — " +
                        "Our society; culture and identity",
                "Groups in the community and how identity is linked or " +
                        "challenged by membership of these groups; also explore the " +
                        "role of the arts as a contributor to the formation of " +
                        "culture and identity, and how sporting and leisure " +
                        "activities both reflect and shape our lifestyle.");
        unitCatalogue.addUnit(unit);
        unit = new Unit(subject, '4',
                "Mi presente; mi futuro — My present; my future",
                "Opportunities to use complex Spanish and to explore " +
                        "perspectives on issues relevant to their futures and to " +
                        "the futures of their peers, and to consider the role of " +
                        "Spanish in their future lives.");
        unitCatalogue.addUnit(unit);
        subject = new Subject("Trade Course",
                "A trade course with no QCAA units or exams.");
        subjectCatalogue.addSubject(subject);
        unit = new Unit(subject, 'X', "Trade Course",
                "A trade course with no QCAA units or exams.");
        unitCatalogue.addUnit(unit);
        subject = new Subject("Another Trade Course",
                "Another trade course with no QCAA units or exams.");
        subjectCatalogue.addSubject(subject);
        unit = new Unit(subject, 'X', "Another Trade Course",
                "Another trade course with no QCAA units or exams.");
        unitCatalogue.addUnit(unit);
        subject = new Subject("Visual Art",
                "Construct knowledge and communicate personal " +
                        "interpretations by working as both artist and audience.");
        subjectCatalogue.addSubject(subject);
        unit = new Unit(subject, '3', "Art as knowledge",
                "Build knowledge about art, artist and audience to " +
                        "generate a personal focus and commence a body of work and " +
                        "employ new knowledge inspired by their personal interests, " +
                        "beliefs and bservations of the world.");
        unitCatalogue.addUnit(unit);
        unit = new Unit(subject, '4', "Art as alternate",
                "Refine expression and personal aesthetic by applying " +
                        "skills associated with creative thinking and resolve " +
                        "their body of work as they imagine, generate and apply " +
                        "new ideas and links.");
        unitCatalogue.addUnit(unit);
    }

    /**
     * Load up all the Year 12 Students.
     */
    private void populateCohort() {
        Student student = new Student(9999365663L,"Liam Alexander",
                "Smith",8,12,2007,"Blue");
        student.addSubject(subjectCatalogue.byTitle("Essential English"));
        student.addSubject(subjectCatalogue.byTitle("Essential Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Ancient History"));
        student.addSubject(subjectCatalogue.byTitle("Industrial Technology Skills"));
        student.addSubject(subjectCatalogue.byTitle("Trade Course"));
        student.addSubject(subjectCatalogue.byTitle("Another Trade Course"));
        cohort.add(student);
        student = new Student(9999440022L,"Noah James",
                "Brown",27,7,2007,"Green");
        student.addSubject(subjectCatalogue.byTitle("Essential English"));
        student.addSubject(subjectCatalogue.byTitle("Essential Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Ancient History"));
        student.addSubject(subjectCatalogue.byTitle("Industrial Technology Skills"));
        student.addSubject(subjectCatalogue.byTitle("Trade Course"));
        student.addSubject(subjectCatalogue.byTitle("Another Trade Course"));
        cohort.add(student);
        student = new Student(9999063966L,"Oliver Henry",
                "Johnson",11,7,2007,"Red");
        student.addSubject(subjectCatalogue.byTitle("Essential English"));
        student.addSubject(subjectCatalogue.byTitle("Essential Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Ancient History"));
        student.addSubject(subjectCatalogue.byTitle("Industrial Technology Skills"));
        student.addSubject(subjectCatalogue.byTitle("Trade Course"));
        student.addSubject(subjectCatalogue.byTitle("Another Trade Course"));
        cohort.add(student);
        student = new Student(9999313004L,"Jack Thomas",
                "Williams",17,9,2007,"White");
        student.addSubject(subjectCatalogue.byTitle("Essential English"));
        student.addSubject(subjectCatalogue.byTitle("Essential Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Modern History"));
        student.addSubject(subjectCatalogue.byTitle("Industrial Technology Skills"));
        student.addSubject(subjectCatalogue.byTitle("Trade Course"));
        student.addSubject(subjectCatalogue.byTitle("Another Trade Course"));
        cohort.add(student);
        student = new Student(9999521703L,"Henry William",
                "Taylor",4,4,2008,"Yellow");
        student.addSubject(subjectCatalogue.byTitle("Essential English"));
        student.addSubject(subjectCatalogue.byTitle("Essential Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Modern History"));
        student.addSubject(subjectCatalogue.byTitle("Industrial Technology Skills"));
        student.addSubject(subjectCatalogue.byTitle("Trade Course"));
        student.addSubject(subjectCatalogue.byTitle("Another Trade Course"));
        cohort.add(student);
        student = new Student(9999191361L,"Leo Hunter",
                "White",6,10,2007,"Blue");
        student.addSubject(subjectCatalogue.byTitle("Essential English"));
        student.addSubject(subjectCatalogue.byTitle("Essential Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Modern History"));
        student.addSubject(subjectCatalogue.byTitle("Industrial Technology Skills"));
        student.addSubject(subjectCatalogue.byTitle("Trade Course"));
        student.addSubject(subjectCatalogue.byTitle("Another Trade Course"));
        cohort.add(student);
        student = new Student(9999986913L,"Lucas Ethan",
                "Harris",22,10,2007,"Green");
        student.addSubject(subjectCatalogue.byTitle("Essential English"));
        student.addSubject(subjectCatalogue.byTitle("Essential Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Psychology"));
        student.addSubject(subjectCatalogue.byTitle("Industrial Technology Skills"));
        student.addSubject(subjectCatalogue.byTitle("Trade Course"));
        student.addSubject(subjectCatalogue.byTitle("Another Trade Course"));
        cohort.add(student);
        student = new Student(9999572152L,"John Michael",
                "Hall",25,5,2008,"Red");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("Mathematical Methods"));
        student.addSubject(subjectCatalogue.byTitle("Engineering"));
        student.addSubject(subjectCatalogue.byTitle("Chemistry"));
        student.addSubject(subjectCatalogue.byTitle("Biology"));
        student.addSubject(subjectCatalogue.byTitle("Physics"));
        cohort.add(student);
        student = new Student(9999147144L,"Hunter Riley",
                "Davis",1,1,2008,"White");
        student.addSubject(subjectCatalogue.byTitle("Essential English"));
        student.addSubject(subjectCatalogue.byTitle("Essential Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Psychology"));
        student.addSubject(subjectCatalogue.byTitle("Industrial Technology Skills"));
        student.addSubject(subjectCatalogue.byTitle("Trade Course"));
        student.addSubject(subjectCatalogue.byTitle("Another Trade Course"));
        cohort.add(student);
        student = new Student(9999345181L,"Mason Elijah",
                "Douglas-Walker",22,2,2008,"Yellow");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("Essential Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Ancient History"));
        student.addSubject(subjectCatalogue.byTitle("Business"));
        student.addSubject(subjectCatalogue.byTitle("Accounting"));
        student.addSubject(subjectCatalogue.byTitle("Economics"));
        cohort.add(student);
        student = new Student(9999752965L,"James Matthew",
                "Allen",14,2,2008,"Blue");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("Essential Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Food and Nutrition"));
        student.addSubject(subjectCatalogue.byTitle("Modern History"));
        student.addSubject(subjectCatalogue.byTitle("Physical Education"));
        student.addSubject(subjectCatalogue.byTitle("Philosophy and Reason"));
        cohort.add(student);
        student = new Student(9999949072L,"Aiden Samuel",
                "Young",9,5,2008,"Green");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Food and Nutrition"));
        student.addSubject(subjectCatalogue.byTitle("Modern History"));
        student.addSubject(subjectCatalogue.byTitle("Physical Education"));
        student.addSubject(subjectCatalogue.byTitle("Philosophy and Reason"));
        cohort.add(student);
        student = new Student(9999615678L,"Alexander Joshua",
                "King",11,7,2007,"Red");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Food and Nutrition"));
        student.addSubject(subjectCatalogue.byTitle("Modern History"));
        student.addSubject(subjectCatalogue.byTitle("Physical Education"));
        student.addSubject(subjectCatalogue.byTitle("Philosophy and Reason"));
        cohort.add(student);
        student = new Student(9999787134L,"Thomas Jason Ryan",
                "Wright",23,7,2007,"White");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Food and Nutrition"));
        student.addSubject(subjectCatalogue.byTitle("Modern History"));
        student.addSubject(subjectCatalogue.byTitle("Physical Education"));
        student.addSubject(subjectCatalogue.byTitle("Geography"));
        cohort.add(student);
        student = new Student(9999230108L,"William Logan",
                "Adams",1,9,2007,"Yellow");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Food and Nutrition"));
        student.addSubject(subjectCatalogue.byTitle("Modern History"));
        student.addSubject(subjectCatalogue.byTitle("Physical Education"));
        student.addSubject(subjectCatalogue.byTitle("Geography"));
        cohort.add(student);
        student = new Student(9999708026L,"Samuel Dylan",
                "Scott",15,3,2008,"Blue");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Food and Nutrition"));
        student.addSubject(subjectCatalogue.byTitle("Business"));
        student.addSubject(subjectCatalogue.byTitle("Physical Education"));
        student.addSubject(subjectCatalogue.byTitle("Modern History"));
        cohort.add(student);
        student = new Student(9999714498L,"Charlie Benjamin",
                "Morris",19,7,2007,"Green");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Spanish"));
        student.addSubject(subjectCatalogue.byTitle("Business"));
        student.addSubject(subjectCatalogue.byTitle("Modern History"));
        student.addSubject(subjectCatalogue.byTitle("Geography"));
        cohort.add(student);
        student = new Student(9999311950L,"Ryan Oliver",
                "Hughes",27,11,2007,"Red");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Psychology"));
        student.addSubject(subjectCatalogue.byTitle("Business"));
        student.addSubject(subjectCatalogue.byTitle("Modern History"));
        student.addSubject(subjectCatalogue.byTitle("Geography"));
        cohort.add(student);
        student = new Student(9999975011L,"Isaac Austin",
                "Campbell",20,12,2007,"White");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Philosophy and Reason"));
        student.addSubject(subjectCatalogue.byTitle("Business"));
        student.addSubject(subjectCatalogue.byTitle("Accounting"));
        student.addSubject(subjectCatalogue.byTitle("Modern History"));
        cohort.add(student);
        student = new Student(9999570523L,"Dylan Jacob",
                "Turner",20,8,2007,"Yellow");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Philosophy and Reason"));
        student.addSubject(subjectCatalogue.byTitle("Business"));
        student.addSubject(subjectCatalogue.byTitle("Accounting"));
        student.addSubject(subjectCatalogue.byTitle("Modern History"));
        cohort.add(student);
        student = new Student(9999069787L,"Benjamin",
                "Lee",8,8,2007,"Blue");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Philosophy and Reason"));
        student.addSubject(subjectCatalogue.byTitle("Biology"));
        student.addSubject(subjectCatalogue.byTitle("Psychology"));
        student.addSubject(subjectCatalogue.byTitle("German"));
        cohort.add(student);
        student = new Student(9999540711L,"Logan Caleb",
                "Robinson",28,4,2008,"Green");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Philosophy and Reason"));
        student.addSubject(subjectCatalogue.byTitle("Biology"));
        student.addSubject(subjectCatalogue.byTitle("Psychology"));
        student.addSubject(subjectCatalogue.byTitle("German"));
        cohort.add(student);
        student = new Student(9999198880L,"Owen Jaxon",
                "Wood",21,5,2008,"Red");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Modern History"));
        student.addSubject(subjectCatalogue.byTitle("Biology"));
        student.addSubject(subjectCatalogue.byTitle("Ancient History"));
        student.addSubject(subjectCatalogue.byTitle("German"));
        cohort.add(student);
        student = new Student(9999305484L,"Max Theodore",
                "Mitchell",1,1,2008,"White");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Modern History"));
        student.addSubject(subjectCatalogue.byTitle("Biology"));
        student.addSubject(subjectCatalogue.byTitle("Ancient History"));
        student.addSubject(subjectCatalogue.byTitle("Drama"));
        cohort.add(student);
        student = new Student(9999076847L,"Caleb Alexander",
                "Ward",12,12,2007,"Yellow");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Modern History"));
        student.addSubject(subjectCatalogue.byTitle("Biology"));
        student.addSubject(subjectCatalogue.byTitle("Ancient History"));
        student.addSubject(subjectCatalogue.byTitle("Drama"));
        cohort.add(student);
        student = new Student(9999091495L,"Harry Nathan",
                "Kelly",16,8,2007,"Blue");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Visual Art"));
        student.addSubject(subjectCatalogue.byTitle("Music"));
        student.addSubject(subjectCatalogue.byTitle("Ancient History"));
        student.addSubject(subjectCatalogue.byTitle("Drama"));
        cohort.add(student);
        student = new Student(9999405537L,"Austin Spencer",
                "Price",10,10,2007,"Green");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Visual Art"));
        student.addSubject(subjectCatalogue.byTitle("Music"));
        student.addSubject(subjectCatalogue.byTitle("Ancient History"));
        student.addSubject(subjectCatalogue.byTitle("Drama"));
        cohort.add(student);
        student = new Student(9999300154L,"Flynn Patrick",
                "Bennett",19,11,2007,"Red");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Visual Art"));
        student.addSubject(subjectCatalogue.byTitle("Music"));
        student.addSubject(subjectCatalogue.byTitle("Biology"));
        student.addSubject(subjectCatalogue.byTitle("Drama"));
        cohort.add(student);
        student = new Student(9999165781L,"Jaxon Xavier",
                "Stewart",18,2,2008,"White");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Visual Art"));
        student.addSubject(subjectCatalogue.byTitle("Music"));
        student.addSubject(subjectCatalogue.byTitle("Biology"));
        student.addSubject(subjectCatalogue.byTitle("Drama"));
        cohort.add(student);
        student = new Student(9999826988L,"James Elijah",
                "Cook",5,9,2007,"Yellow");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Visual Art"));
        student.addSubject(subjectCatalogue.byTitle("Music"));
        student.addSubject(subjectCatalogue.byTitle("Biology"));
        student.addSubject(subjectCatalogue.byTitle("Drama"));
        cohort.add(student);
        student = new Student(9999506179L,"Ranma",
                "Saotome",20,8,2007,"Blue");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Japanese"));
        student.addSubject(subjectCatalogue.byTitle("Music"));
        student.addSubject(subjectCatalogue.byTitle("Biology"));
        student.addSubject(subjectCatalogue.byTitle("Drama"));
        cohort.add(student);
        student = new Student(9999141650L,"Finn Levi",
                "Carter",23,3,2008,"Green");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Psychology"));
        student.addSubject(subjectCatalogue.byTitle("Biology"));
        student.addSubject(subjectCatalogue.byTitle("Ancient History"));
        student.addSubject(subjectCatalogue.byTitle("Modern History"));
        cohort.add(student);
        student = new Student(9999241493L,"Tyler Sebastian",
                "Rogers",18,6,2008,"Red");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Psychology"));
        student.addSubject(subjectCatalogue.byTitle("Biology"));
        student.addSubject(subjectCatalogue.byTitle("Ancient History"));
        student.addSubject(subjectCatalogue.byTitle("Modern History"));
        cohort.add(student);
        student = new Student(9999214667L,"Kai Ashton",
                "Edwards",16,12,2007,"White");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Engineering"));
        student.addSubject(subjectCatalogue.byTitle("Biology"));
        student.addSubject(subjectCatalogue.byTitle("Ancient History"));
        student.addSubject(subjectCatalogue.byTitle("Design"));
        cohort.add(student);
        student = new Student(9999124963L,"Archie Blake",
                "Hughes",24,8,2007,"Yellow");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Engineering"));
        student.addSubject(subjectCatalogue.byTitle("Biology"));
        student.addSubject(subjectCatalogue.byTitle("Ancient History"));
        student.addSubject(subjectCatalogue.byTitle("Design"));
        cohort.add(student);
        student = new Student(9999672024L,"Matthew Harrison",
                "Murphy",21,1,2008,"Blue");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Ancient History"));
        student.addSubject(subjectCatalogue.byTitle("Business"));
        student.addSubject(subjectCatalogue.byTitle("Accounting"));
        student.addSubject(subjectCatalogue.byTitle("Economics"));
        cohort.add(student);
        student = new Student(9999872137L,"Sebastian Adam Luke",
                "Butler",18,2,2008,"Green");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Ancient History"));
        student.addSubject(subjectCatalogue.byTitle("Business"));
        student.addSubject(subjectCatalogue.byTitle("Accounting"));
        student.addSubject(subjectCatalogue.byTitle("Economics"));
        cohort.add(student);
        student = new Student(9999129059L,"Blake Mitchell",
                "Perry",4,12,2007,"Red");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Engineering"));
        student.addSubject(subjectCatalogue.byTitle("Physics"));
        student.addSubject(subjectCatalogue.byTitle("Modern History"));
        student.addSubject(subjectCatalogue.byTitle("Economics"));
        cohort.add(student);
        student = new Student(9999626008L,"Nathan Felix",
                "Russell",9,5,2008,"White");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Engineering"));
        student.addSubject(subjectCatalogue.byTitle("Physics"));
        student.addSubject(subjectCatalogue.byTitle("Biology"));
        student.addSubject(subjectCatalogue.byTitle("Digital Solutions"));
        cohort.add(student);
        student = new Student(9999878184L,"Ashton Connor",
                "Cooper",17,1,2008,"Yellow");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Philosophy and Reason"));
        student.addSubject(subjectCatalogue.byTitle("Business"));
        student.addSubject(subjectCatalogue.byTitle("Biology"));
        student.addSubject(subjectCatalogue.byTitle("Digital Solutions"));
        cohort.add(student);
        student = new Student(9999646984L,"Spencer Luke",
                "Fisher",13,5,2008,"Blue");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Philosophy and Reason"));
        student.addSubject(subjectCatalogue.byTitle("Business"));
        student.addSubject(subjectCatalogue.byTitle("Biology"));
        student.addSubject(subjectCatalogue.byTitle("Digital Solutions"));
        cohort.add(student);
        student = new Student(9999406335L,"Felix Angus",
                "Howard",24,4,2008,"Green",true);
        student.addSubject(subjectCatalogue.byTitle("Essential English"));
        student.addSubject(subjectCatalogue.byTitle("Essential Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Philosophy and Reason"));
        student.addSubject(subjectCatalogue.byTitle("Industrial Technology Skills"));
        student.addSubject(subjectCatalogue.byTitle("Trade Course"));
        student.addSubject(subjectCatalogue.byTitle("Another Trade Course"));
        cohort.add(student);
        student = new Student(9999494320L,"Connor Byron",
                "Bailey",5,5,2008,"Red",true);
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("Mathematical Methods"));
        student.addSubject(subjectCatalogue.byTitle("Biology"));
        student.addSubject(subjectCatalogue.byTitle("Modern History"));
        student.addSubject(subjectCatalogue.byTitle("Geography"));
        student.addSubject(subjectCatalogue.byTitle("Physics"));
        cohort.add(student);
        student = new Student(9999827127L,"John Michael",
                "Hall",4,4,2008,"White",true);
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("Mathematical Methods"));
        student.addSubject(subjectCatalogue.byTitle("Modern History"));
        student.addSubject(subjectCatalogue.byTitle("Chemistry"));
        student.addSubject(subjectCatalogue.byTitle("Biology"));
        student.addSubject(subjectCatalogue.byTitle("Physics"));
        cohort.add(student);
        student = new Student(9999761122L,"Joshua Ezra",
                "Brooks",23,11,2007,"Yellow",true);
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("Mathematical Methods"));
        student.addSubject(subjectCatalogue.byTitle("Biology"));
        student.addSubject(subjectCatalogue.byTitle("Physics"));
        student.addSubject(subjectCatalogue.byTitle("Psychology"));
        student.addSubject(subjectCatalogue.byTitle("Economics"));
        cohort.add(student);
        student = new Student(9999113425L,"Zachary Jacob",
                "Reid",22,2,2008,"Blue",true);
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Ancient History"));
        student.addSubject(subjectCatalogue.byTitle("Business"));
        student.addSubject(subjectCatalogue.byTitle("Legal Studies"));
        student.addSubject(subjectCatalogue.byTitle("Economics"));
        cohort.add(student);
        student = new Student(9999346945L,"Aaron Riley",
                "Foster",22,2,2008,"Green",true);
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Food and Nutrition"));
        student.addSubject(subjectCatalogue.byTitle("Modern History"));
        student.addSubject(subjectCatalogue.byTitle("Physical Education"));
        student.addSubject(subjectCatalogue.byTitle("Geography"));
        cohort.add(student);
        student = new Student(9999479827L,"Jacob Harvey",
                "Henderson",16,8,2007,"Red",true);
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Food and Nutrition"));
        student.addSubject(subjectCatalogue.byTitle("Modern History"));
        student.addSubject(subjectCatalogue.byTitle("Physical Education"));
        student.addSubject(subjectCatalogue.byTitle("Geography"));
        cohort.add(student);
        student = new Student(9999211367L,"Riley Jonah",
                "Sanders",20,12,2007,"White",true);
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Biology"));
        student.addSubject(subjectCatalogue.byTitle("Physics"));
        student.addSubject(subjectCatalogue.byTitle("Chemistry"));
        student.addSubject(subjectCatalogue.byTitle("Geography"));
        cohort.add(student);
        student = new Student(9999758853L,"Adam Declan",
                "Knight",22,10,2007,"Yellow",true);
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Biology"));
        student.addSubject(subjectCatalogue.byTitle("Physics"));
        student.addSubject(subjectCatalogue.byTitle("Chemistry"));
        student.addSubject(subjectCatalogue.byTitle("Geography"));
        cohort.add(student);
        student = new Student(9999681086L,"Eli Micah",
                "Cox",11,3,2008,"Blue",true);
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Psychology"));
        student.addSubject(subjectCatalogue.byTitle("Biology"));
        student.addSubject(subjectCatalogue.byTitle("Chemistry"));
        student.addSubject(subjectCatalogue.byTitle("Geography"));
        cohort.add(student);
        student = new Student(9999647413L,"Angus Marcus",
                "Mitchell",22,2,2008,"Green",true);
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Visual Art"));
        student.addSubject(subjectCatalogue.byTitle("Music"));
        student.addSubject(subjectCatalogue.byTitle("Psychology"));
        student.addSubject(subjectCatalogue.byTitle("Drama"));
        cohort.add(student);
        student = new Student(9999805691L,"Luke Theodore",
                "Webb",16,12,2007,"Red",true);
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Visual Art"));
        student.addSubject(subjectCatalogue.byTitle("Music"));
        student.addSubject(subjectCatalogue.byTitle("Psychology"));
        student.addSubject(subjectCatalogue.byTitle("Drama"));
        cohort.add(student);
        student = new Student(9999079955L,"Byron Mitchell",
                "Stone",12,12,2007,"White",true);
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Visual Art"));
        student.addSubject(subjectCatalogue.byTitle("Music"));
        student.addSubject(subjectCatalogue.byTitle("Psychology"));
        student.addSubject(subjectCatalogue.byTitle("Design"));
        cohort.add(student);
        student = new Student(9999837962L,"Cameron Levi",
                "Porter",3,3,2008,"Yellow",true);
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Visual Art"));
        student.addSubject(subjectCatalogue.byTitle("Music"));
        student.addSubject(subjectCatalogue.byTitle("Psychology"));
        student.addSubject(subjectCatalogue.byTitle("Design"));
        cohort.add(student);
        student = new Student(9999706965L,"Jonah Marcus",
                "Sharp",18,10,2007,"Blue",true);
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Ancient History"));
        student.addSubject(subjectCatalogue.byTitle("Physics"));
        student.addSubject(subjectCatalogue.byTitle("Geography"));
        student.addSubject(subjectCatalogue.byTitle("Digital Solutions"));
        cohort.add(student);
        student = new Student(9999865763L,"Chen Aaron",
                "Wang",28,12,2007,"Green",true);
        student.addSubject(subjectCatalogue.byTitle("Literature"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Ancient History"));
        student.addSubject(subjectCatalogue.byTitle("Physics"));
        student.addSubject(subjectCatalogue.byTitle("Geography"));
        student.addSubject(subjectCatalogue.byTitle("Digital Solutions"));
        cohort.add(student);
        student = new Student(9999248162L,"Omar Jacob",
                "Hassan",23,3,2008,"Red",true);
        student.addSubject(subjectCatalogue.byTitle("Literature"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Biology"));
        student.addSubject(subjectCatalogue.byTitle("Physics"));
        student.addSubject(subjectCatalogue.byTitle("Geography"));
        student.addSubject(subjectCatalogue.byTitle("Digital Solutions"));
        cohort.add(student);
        student = new Student(9999913083L,"Harrison Jayden",
                "Gibson",28,4,2008,"White",true);
        student.addSubject(subjectCatalogue.byTitle("Literature"));
        student.addSubject(subjectCatalogue.byTitle("Mathematical Methods"));
        student.addSubject(subjectCatalogue.byTitle("Engineering"));
        student.addSubject(subjectCatalogue.byTitle("Physics"));
        student.addSubject(subjectCatalogue.byTitle("Geography"));
        student.addSubject(subjectCatalogue.byTitle("Digital Solutions"));
        cohort.add(student);
        student = new Student(9999559970L,"Theodore Declan",
                "Ellis",23,3,2008,"Yellow",true);
        student.addSubject(subjectCatalogue.byTitle("Literature"));
        student.addSubject(subjectCatalogue.byTitle("Mathematical Methods"));
        student.addSubject(subjectCatalogue.byTitle("Engineering"));
        student.addSubject(subjectCatalogue.byTitle("Chemistry"));
        student.addSubject(subjectCatalogue.byTitle("Specialist Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Physics"));
        cohort.add(student);
        student = new Student(9999148941L,"Muhammad Abdullah",
                "Khalid",6,10,2007,"Blue",true);
        student.addSubject(subjectCatalogue.byTitle("Literature"));
        student.addSubject(subjectCatalogue.byTitle("Mathematical Methods"));
        student.addSubject(subjectCatalogue.byTitle("Engineering"));
        student.addSubject(subjectCatalogue.byTitle("Chemistry"));
        student.addSubject(subjectCatalogue.byTitle("Specialist Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Physics"));
        cohort.add(student);
        student = new Student(9999493906L,"Mitchell Cameron",
                "Black",11,11,2007,"Green",true);
        student.addSubject(subjectCatalogue.byTitle("Literature"));
        student.addSubject(subjectCatalogue.byTitle("Mathematical Methods"));
        student.addSubject(subjectCatalogue.byTitle("Engineering"));
        student.addSubject(subjectCatalogue.byTitle("Chemistry"));
        student.addSubject(subjectCatalogue.byTitle("Specialist Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("English and Literature Extension"));
        cohort.add(student);
        student = new Student(9999374704L,"Harvey Patrick",
                "Fraser",5,5,2008,"Red");
        student.addSubject(subjectCatalogue.byTitle("Literature"));
        student.addSubject(subjectCatalogue.byTitle("Mathematical Methods"));
        student.addSubject(subjectCatalogue.byTitle("Engineering"));
        student.addSubject(subjectCatalogue.byTitle("Ancient History"));
        student.addSubject(subjectCatalogue.byTitle("Biology"));
        student.addSubject(subjectCatalogue.byTitle("Physics"));
        cohort.add(student);
        student = new Student(9999831867L,"Cameron Elijah",
                "Walsh-Bennett",12,4,2008,"White");
        student.addSubject(subjectCatalogue.byTitle("Literature"));
        student.addSubject(subjectCatalogue.byTitle("Mathematical Methods"));
        student.addSubject(subjectCatalogue.byTitle("Engineering"));
        student.addSubject(subjectCatalogue.byTitle("Chemistry"));
        student.addSubject(subjectCatalogue.byTitle("Biology"));
        student.addSubject(subjectCatalogue.byTitle("Physics"));
        cohort.add(student);
        student = new Student(9999896932L,"Hiroshi Benjamin",
                "Tanaka",5,5,2008,"Yellow");
        student.addSubject(subjectCatalogue.byTitle("Literature"));
        student.addSubject(subjectCatalogue.byTitle("Mathematical Methods"));
        student.addSubject(subjectCatalogue.byTitle("Japanese"));
        student.addSubject(subjectCatalogue.byTitle("Chemistry"));
        student.addSubject(subjectCatalogue.byTitle("Biology"));
        student.addSubject(subjectCatalogue.byTitle("Physics"));
        cohort.add(student);
        student = new Student(9999831170L,"Tariq Nathan",
                "Ahmad",15,3,2008,"Blue");
        student.addSubject(subjectCatalogue.byTitle("Literature"));
        student.addSubject(subjectCatalogue.byTitle("Mathematical Methods"));
        student.addSubject(subjectCatalogue.byTitle("Engineering"));
        student.addSubject(subjectCatalogue.byTitle("Chemistry"));
        student.addSubject(subjectCatalogue.byTitle("Biology"));
        student.addSubject(subjectCatalogue.byTitle("English and Literature Extension"));
        cohort.add(student);
        student = new Student(9999605671L,"Elijah Carter",
                "Newman",28,8,2007,"Green");
        student.addSubject(subjectCatalogue.byTitle("Literature"));
        student.addSubject(subjectCatalogue.byTitle("Mathematical Methods"));
        student.addSubject(subjectCatalogue.byTitle("Engineering"));
        student.addSubject(subjectCatalogue.byTitle("Chemistry"));
        student.addSubject(subjectCatalogue.byTitle("Biology"));
        student.addSubject(subjectCatalogue.byTitle("Physics"));
        cohort.add(student);
        student = new Student(9999209287L,"Sebastian James",
                "Hart",12,8,2007,"Red");
        student.addSubject(subjectCatalogue.byTitle("Literature"));
        student.addSubject(subjectCatalogue.byTitle("Mathematical Methods"));
        student.addSubject(subjectCatalogue.byTitle("Engineering"));
        student.addSubject(subjectCatalogue.byTitle("Chemistry"));
        student.addSubject(subjectCatalogue.byTitle("Biology"));
        student.addSubject(subjectCatalogue.byTitle("Physics"));
        cohort.add(student);
        student = new Student(9999479243L,"Alexander Flynn",
                "Watson",20,12,2007,"White");
        student.addSubject(subjectCatalogue.byTitle("Literature"));
        student.addSubject(subjectCatalogue.byTitle("Mathematical Methods"));
        student.addSubject(subjectCatalogue.byTitle("Engineering"));
        student.addSubject(subjectCatalogue.byTitle("Physics"));
        student.addSubject(subjectCatalogue.byTitle("Specialist Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Chemistry"));
        cohort.add(student);
        student = new Student(9999144365L,"Jordan Isaac",
                "Lane",22,6,2008,"Yellow");
        student.addSubject(subjectCatalogue.byTitle("Literature"));
        student.addSubject(subjectCatalogue.byTitle("Mathematical Methods"));
        student.addSubject(subjectCatalogue.byTitle("Engineering"));
        student.addSubject(subjectCatalogue.byTitle("Physics"));
        student.addSubject(subjectCatalogue.byTitle("Specialist Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Chemistry"));
        cohort.add(student);
        student = new Student(9999419471L,"Caleb Ashton",
                "Green",28,12,2007,"Blue");
        student.addSubject(subjectCatalogue.byTitle("Literature"));
        student.addSubject(subjectCatalogue.byTitle("Mathematical Methods"));
        student.addSubject(subjectCatalogue.byTitle("Biology"));
        student.addSubject(subjectCatalogue.byTitle("Chemistry"));
        student.addSubject(subjectCatalogue.byTitle("Specialist Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Physics"));
        cohort.add(student);
        student = new Student(9999880219L,"Luca Nathaniel",
                "Ward",8,8,2007,"Green");
        student.addSubject(subjectCatalogue.byTitle("Literature"));
        student.addSubject(subjectCatalogue.byTitle("Mathematical Methods"));
        student.addSubject(subjectCatalogue.byTitle("Biology"));
        student.addSubject(subjectCatalogue.byTitle("Chemistry"));
        student.addSubject(subjectCatalogue.byTitle("Specialist Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Physics"));
        cohort.add(student);
        student = new Student(9999672610L,"Aiden Patrick",
                "Snow",19,11,2007,"Red");
        student.addSubject(subjectCatalogue.byTitle("Literature"));
        student.addSubject(subjectCatalogue.byTitle("Mathematical Methods"));
        student.addSubject(subjectCatalogue.byTitle("Biology"));
        student.addSubject(subjectCatalogue.byTitle("Chemistry"));
        student.addSubject(subjectCatalogue.byTitle("Specialist Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Physics"));
        cohort.add(student);
        student = new Student(9999257005L,"Noah Elijah",
                "Carpenter",18,2,2008,"White");
        student.addSubject(subjectCatalogue.byTitle("Literature"));
        student.addSubject(subjectCatalogue.byTitle("Mathematical Methods"));
        student.addSubject(subjectCatalogue.byTitle("Biology"));
        student.addSubject(subjectCatalogue.byTitle("Chemistry"));
        student.addSubject(subjectCatalogue.byTitle("Specialist Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Physics"));
        cohort.add(student);
        student = new Student(9999929778L,"Akio Jacob",
                "Watanabe",7,7,2007,"Yellow");
        student.addSubject(subjectCatalogue.byTitle("Literature"));
        student.addSubject(subjectCatalogue.byTitle("Mathematical Methods"));
        student.addSubject(subjectCatalogue.byTitle("Japanese"));
        student.addSubject(subjectCatalogue.byTitle("Chemistry"));
        student.addSubject(subjectCatalogue.byTitle("Specialist Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Digital Solutions"));
        cohort.add(student);
        student = new Student(9999280542L,"Olivia Grace",
                "Smith",7,7,2007,"Blue");
        student.addSubject(subjectCatalogue.byTitle("Essential English"));
        student.addSubject(subjectCatalogue.byTitle("Essential Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Ancient History"));
        student.addSubject(subjectCatalogue.byTitle("Industrial Technology Skills"));
        student.addSubject(subjectCatalogue.byTitle("Trade Course"));
        student.addSubject(subjectCatalogue.byTitle("Another Trade Course"));
        cohort.add(student);
        student = new Student(9999072292L,"Charlotte Ava",
                "Brown",21,5,2008,"Green");
        student.addSubject(subjectCatalogue.byTitle("Essential English"));
        student.addSubject(subjectCatalogue.byTitle("Essential Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Ancient History"));
        student.addSubject(subjectCatalogue.byTitle("Industrial Technology Skills"));
        student.addSubject(subjectCatalogue.byTitle("Trade Course"));
        student.addSubject(subjectCatalogue.byTitle("Another Trade Course"));
        cohort.add(student);
        student = new Student(9999106094L,"Amelia Rose",
                "Johnson",27,3,2008,"Red");
        student.addSubject(subjectCatalogue.byTitle("Essential English"));
        student.addSubject(subjectCatalogue.byTitle("Essential Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Ancient History"));
        student.addSubject(subjectCatalogue.byTitle("Industrial Technology Skills"));
        student.addSubject(subjectCatalogue.byTitle("Trade Course"));
        student.addSubject(subjectCatalogue.byTitle("Another Trade Course"));
        cohort.add(student);
        student = new Student(9999131191L,"Isla",
                "Williams",8,8,2007,"White");
        student.addSubject(subjectCatalogue.byTitle("Essential English"));
        student.addSubject(subjectCatalogue.byTitle("Essential Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Modern History"));
        student.addSubject(subjectCatalogue.byTitle("Industrial Technology Skills"));
        student.addSubject(subjectCatalogue.byTitle("Trade Course"));
        student.addSubject(subjectCatalogue.byTitle("Another Trade Course"));
        cohort.add(student);
        student = new Student(9999955931L,"Ava Harper",
                "Taylor",8,12,2007,"Yellow");
        student.addSubject(subjectCatalogue.byTitle("Essential English"));
        student.addSubject(subjectCatalogue.byTitle("Essential Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Modern History"));
        student.addSubject(subjectCatalogue.byTitle("Industrial Technology Skills"));
        student.addSubject(subjectCatalogue.byTitle("Trade Course"));
        student.addSubject(subjectCatalogue.byTitle("Another Trade Course"));
        cohort.add(student);
        student = new Student(9999242025L,"Mia Lily",
                "White",18,10,2007,"Blue");
        student.addSubject(subjectCatalogue.byTitle("Essential English"));
        student.addSubject(subjectCatalogue.byTitle("Essential Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Modern History"));
        student.addSubject(subjectCatalogue.byTitle("Industrial Technology Skills"));
        student.addSubject(subjectCatalogue.byTitle("Trade Course"));
        student.addSubject(subjectCatalogue.byTitle("Another Trade Course"));
        cohort.add(student);
        student = new Student(9999619188L,"Charlotte Sophie",
                "Brown",21,1,2008,"Green");
        student.addSubject(subjectCatalogue.byTitle("Essential English"));
        student.addSubject(subjectCatalogue.byTitle("Essential Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Psychology"));
        student.addSubject(subjectCatalogue.byTitle("Industrial Technology Skills"));
        student.addSubject(subjectCatalogue.byTitle("Trade Course"));
        student.addSubject(subjectCatalogue.byTitle("Another Trade Course"));
        cohort.add(student);
        student = new Student(9999543293L,"Lily Chloe",
                "Hall",6,6,2008,"Red");
        student.addSubject(subjectCatalogue.byTitle("Essential English"));
        student.addSubject(subjectCatalogue.byTitle("Essential Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Psychology"));
        student.addSubject(subjectCatalogue.byTitle("Industrial Technology Skills"));
        student.addSubject(subjectCatalogue.byTitle("Trade Course"));
        student.addSubject(subjectCatalogue.byTitle("Another Trade Course"));
        cohort.add(student);
        student = new Student(9999042588L,"Ella Grace",
                "Davis",25,1,2008,"White");
        student.addSubject(subjectCatalogue.byTitle("Essential English"));
        student.addSubject(subjectCatalogue.byTitle("Essential Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Psychology"));
        student.addSubject(subjectCatalogue.byTitle("Industrial Technology Skills"));
        student.addSubject(subjectCatalogue.byTitle("Trade Course"));
        student.addSubject(subjectCatalogue.byTitle("Another Trade Course"));
        cohort.add(student);
        student = new Student(9999805786L,"Grace Sophia",
                "Walker",27,11,2007,"Yellow");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("Essential Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Ancient History"));
        student.addSubject(subjectCatalogue.byTitle("Business"));
        student.addSubject(subjectCatalogue.byTitle("Accounting"));
        student.addSubject(subjectCatalogue.byTitle("Economics"));
        cohort.add(student);
        student = new Student(9999663040L,"Chloe Ruby",
                "Allen",25,5,2008,"Blue");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("Essential Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Food and Nutrition"));
        student.addSubject(subjectCatalogue.byTitle("Modern History"));
        student.addSubject(subjectCatalogue.byTitle("Physical Education"));
        student.addSubject(subjectCatalogue.byTitle("Philosophy and Reason"));
        cohort.add(student);
        student = new Student(9999312455L,"Zoe Scarlett",
                "Young",28,12,2007,"Green");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Food and Nutrition"));
        student.addSubject(subjectCatalogue.byTitle("Modern History"));
        student.addSubject(subjectCatalogue.byTitle("Physical Education"));
        student.addSubject(subjectCatalogue.byTitle("Philosophy and Reason"));
        cohort.add(student);
        student = new Student(9999604407L,"Evie Sophie",
                "King",24,4,2008,"Red");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Food and Nutrition"));
        student.addSubject(subjectCatalogue.byTitle("Modern History"));
        student.addSubject(subjectCatalogue.byTitle("Physical Education"));
        student.addSubject(subjectCatalogue.byTitle("Philosophy and Reason"));
        cohort.add(student);
        student = new Student(9999464397L,"Emily Zoe",
                "Wright",14,10,2007,"White");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Food and Nutrition"));
        student.addSubject(subjectCatalogue.byTitle("Modern History"));
        student.addSubject(subjectCatalogue.byTitle("Physical Education"));
        student.addSubject(subjectCatalogue.byTitle("Geography"));
        cohort.add(student);
        student = new Student(9999193946L,"Ruby Hannah",
                "Adams",15,3,2008,"Yellow");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Food and Nutrition"));
        student.addSubject(subjectCatalogue.byTitle("Modern History"));
        student.addSubject(subjectCatalogue.byTitle("Physical Education"));
        student.addSubject(subjectCatalogue.byTitle("Geography"));
        cohort.add(student);
        student = new Student(9999452147L,"Scarlett Isla",
                "Scott",28,12,2007,"Blue");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Food and Nutrition"));
        student.addSubject(subjectCatalogue.byTitle("Business"));
        student.addSubject(subjectCatalogue.byTitle("Physical Education"));
        student.addSubject(subjectCatalogue.byTitle("Modern History"));
        cohort.add(student);
        student = new Student(9999443448L,"Sophia Daisy",
                "Morris",9,1,2008,"Green");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Spanish"));
        student.addSubject(subjectCatalogue.byTitle("Business"));
        student.addSubject(subjectCatalogue.byTitle("Modern History"));
        student.addSubject(subjectCatalogue.byTitle("Geography"));
        cohort.add(student);
        student = new Student(9999899616L,"Madison Poppy",
                "Hughes",1,1,2008,"Red");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Psychology"));
        student.addSubject(subjectCatalogue.byTitle("Business"));
        student.addSubject(subjectCatalogue.byTitle("Modern History"));
        student.addSubject(subjectCatalogue.byTitle("Geography"));
        cohort.add(student);
        student = new Student(9999519908L,"Hannah Aria Sophia",
                "Campbell",1,9,2007,"White");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Philosophy and Reason"));
        student.addSubject(subjectCatalogue.byTitle("Business"));
        student.addSubject(subjectCatalogue.byTitle("Accounting"));
        student.addSubject(subjectCatalogue.byTitle("Modern History"));
        cohort.add(student);
        student = new Student(9999087199L,"Lily Chloe",
                "Turner",4,8,2007,"Yellow");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Philosophy and Reason"));
        student.addSubject(subjectCatalogue.byTitle("Business"));
        student.addSubject(subjectCatalogue.byTitle("Accounting"));
        student.addSubject(subjectCatalogue.byTitle("Modern History"));
        cohort.add(student);
        student = new Student(9999829539L,"Zara Audrey",
                "Lee",8,4,2008,"Blue");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Philosophy and Reason"));
        student.addSubject(subjectCatalogue.byTitle("Biology"));
        student.addSubject(subjectCatalogue.byTitle("Psychology"));
        student.addSubject(subjectCatalogue.byTitle("German"));
        cohort.add(student);
        student = new Student(9999140573L,"Audrey Ivy",
                "Robinson",10,6,2008,"Green");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Philosophy and Reason"));
        student.addSubject(subjectCatalogue.byTitle("Biology"));
        student.addSubject(subjectCatalogue.byTitle("Psychology"));
        student.addSubject(subjectCatalogue.byTitle("German"));
        cohort.add(student);
        student = new Student(9999014747L,"Ivy Luna",
                "Wood",16,12,2007,"Red");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Modern History"));
        student.addSubject(subjectCatalogue.byTitle("Biology"));
        student.addSubject(subjectCatalogue.byTitle("Ancient History"));
        student.addSubject(subjectCatalogue.byTitle("German"));
        cohort.add(student);
        student = new Student(9999860158L,"Luna Ellie",
                "Mitchell",23,11,2007,"White");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Modern History"));
        student.addSubject(subjectCatalogue.byTitle("Biology"));
        student.addSubject(subjectCatalogue.byTitle("Ancient History"));
        student.addSubject(subjectCatalogue.byTitle("Drama"));
        cohort.add(student);
        student = new Student(9999227476L,"Ellie Bella",
                "Ward",1,5,2008,"Yellow");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Modern History"));
        student.addSubject(subjectCatalogue.byTitle("Biology"));
        student.addSubject(subjectCatalogue.byTitle("Ancient History"));
        student.addSubject(subjectCatalogue.byTitle("Drama"));
        cohort.add(student);
        student = new Student(9999570468L,"Daisy Hazel",
                "Kelly",21,1,2008,"Blue");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Visual Art"));
        student.addSubject(subjectCatalogue.byTitle("Music"));
        student.addSubject(subjectCatalogue.byTitle("Ancient History"));
        student.addSubject(subjectCatalogue.byTitle("Drama"));
        cohort.add(student);
        student = new Student(9999944203L,"Hazel Mila",
                "Price",12,8,2007,"Green");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Visual Art"));
        student.addSubject(subjectCatalogue.byTitle("Music"));
        student.addSubject(subjectCatalogue.byTitle("Ancient History"));
        student.addSubject(subjectCatalogue.byTitle("Drama"));
        cohort.add(student);
        student = new Student(9999998356L,"Bella Addison",
                "Bennett",13,5,2008,"Red");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Visual Art"));
        student.addSubject(subjectCatalogue.byTitle("Music"));
        student.addSubject(subjectCatalogue.byTitle("Biology"));
        student.addSubject(subjectCatalogue.byTitle("Drama"));
        cohort.add(student);
        student = new Student(9999477013L,"Mila Penelope",
                "Stewart",2,2,2008,"White");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Visual Art"));
        student.addSubject(subjectCatalogue.byTitle("Music"));
        student.addSubject(subjectCatalogue.byTitle("Biology"));
        student.addSubject(subjectCatalogue.byTitle("Drama"));
        cohort.add(student);
        student = new Student(9999439470L,"Poppy Willow",
                "Cook",7,7,2007,"Yellow");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Visual Art"));
        student.addSubject(subjectCatalogue.byTitle("Music"));
        student.addSubject(subjectCatalogue.byTitle("Biology"));
        student.addSubject(subjectCatalogue.byTitle("Drama"));
        cohort.add(student);
        student = new Student(9999432923L,"Savannah Georgia",
                "Cox",12,12,2007,"Blue");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Visual Art"));
        student.addSubject(subjectCatalogue.byTitle("Music"));
        student.addSubject(subjectCatalogue.byTitle("Biology"));
        student.addSubject(subjectCatalogue.byTitle("Drama"));
        cohort.add(student);
        student = new Student(9999296227L,"Addison Aurora",
                "Carter",12,8,2007,"Green");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Psychology"));
        student.addSubject(subjectCatalogue.byTitle("Biology"));
        student.addSubject(subjectCatalogue.byTitle("Ancient History"));
        student.addSubject(subjectCatalogue.byTitle("Modern History"));
        cohort.add(student);
        student = new Student(9999852953L,"Alice Autumn",
                "Rogers",14,6,2008,"Red");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Psychology"));
        student.addSubject(subjectCatalogue.byTitle("Biology"));
        student.addSubject(subjectCatalogue.byTitle("Ancient History"));
        student.addSubject(subjectCatalogue.byTitle("Modern History"));
        cohort.add(student);
        student = new Student(9999491859L,"Penelope Abigail",
                "Edwards",8,4,2008,"White");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Engineering"));
        student.addSubject(subjectCatalogue.byTitle("Biology"));
        student.addSubject(subjectCatalogue.byTitle("Ancient History"));
        student.addSubject(subjectCatalogue.byTitle("Design"));
        cohort.add(student);
        student = new Student(9999053180L,"Willow Sienna",
                "Hughes",5,9,2007,"Yellow");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Engineering"));
        student.addSubject(subjectCatalogue.byTitle("Biology"));
        student.addSubject(subjectCatalogue.byTitle("Ancient History"));
        student.addSubject(subjectCatalogue.byTitle("Design"));
        cohort.add(student);
        student = new Student(9999144668L,"Violet Stella",
                "Murphy",17,9,2007,"Blue");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Ancient History"));
        student.addSubject(subjectCatalogue.byTitle("Business"));
        student.addSubject(subjectCatalogue.byTitle("Accounting"));
        student.addSubject(subjectCatalogue.byTitle("Economics"));
        cohort.add(student);
        student = new Student(9999360661L,"Aurora Florence",
                "Butler",18,2,2008,"Green");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Ancient History"));
        student.addSubject(subjectCatalogue.byTitle("Business"));
        student.addSubject(subjectCatalogue.byTitle("Accounting"));
        student.addSubject(subjectCatalogue.byTitle("Economics"));
        cohort.add(student);
        student = new Student(9999597175L,"Layla Evelyn",
                "Perry",16,8,2007,"Red");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Engineering"));
        student.addSubject(subjectCatalogue.byTitle("Physics"));
        student.addSubject(subjectCatalogue.byTitle("Modern History"));
        student.addSubject(subjectCatalogue.byTitle("Economics"));
        cohort.add(student);
        student = new Student(9999728977L,"Autumn Maeve",
                "Russell",22,2,2008,"White");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Engineering"));
        student.addSubject(subjectCatalogue.byTitle("Physics"));
        student.addSubject(subjectCatalogue.byTitle("Biology"));
        student.addSubject(subjectCatalogue.byTitle("Digital Solutions"));
        cohort.add(student);
        student = new Student(9999266740L,"Abigail Jasmine",
                "Cooper",9,5,2008,"Yellow");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Philosophy and Reason"));
        student.addSubject(subjectCatalogue.byTitle("Business"));
        student.addSubject(subjectCatalogue.byTitle("Biology"));
        student.addSubject(subjectCatalogue.byTitle("Digital Solutions"));
        cohort.add(student);
        student = new Student(9999230891L,"Sienna Clara",
                "Fisher",28,12,2007,"Blue");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Philosophy and Reason"));
        student.addSubject(subjectCatalogue.byTitle("Business"));
        student.addSubject(subjectCatalogue.byTitle("Biology"));
        student.addSubject(subjectCatalogue.byTitle("Digital Solutions"));
        cohort.add(student);
        student = new Student(9999857598L,"Stella Elsie",
                "Howard",11,7,2007,"Green");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("Mathematical Methods"));
        student.addSubject(subjectCatalogue.byTitle("Engineering"));
        student.addSubject(subjectCatalogue.byTitle("Chemistry"));
        student.addSubject(subjectCatalogue.byTitle("Biology"));
        student.addSubject(subjectCatalogue.byTitle("Physics"));
        cohort.add(student);
        student = new Student(9999921901L,"Florence Georgia",
                "Bailey",26,2,2008,"Red");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("Mathematical Methods"));
        student.addSubject(subjectCatalogue.byTitle("Biology"));
        student.addSubject(subjectCatalogue.byTitle("Modern History"));
        student.addSubject(subjectCatalogue.byTitle("Geography"));
        student.addSubject(subjectCatalogue.byTitle("Physics"));
        cohort.add(student);
        student = new Student(9999603740L,"Evelyn Eleanor",
                "Watson",1,9,2007,"White");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("Mathematical Methods"));
        student.addSubject(subjectCatalogue.byTitle("Modern History"));
        student.addSubject(subjectCatalogue.byTitle("Chemistry"));
        student.addSubject(subjectCatalogue.byTitle("Biology"));
        student.addSubject(subjectCatalogue.byTitle("Physics"));
        cohort.add(student);
        student = new Student(9999317903L,"Maeve Piper",
                "Brooks",16,12,2007,"Yellow");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("Mathematical Methods"));
        student.addSubject(subjectCatalogue.byTitle("Biology"));
        student.addSubject(subjectCatalogue.byTitle("Physics"));
        student.addSubject(subjectCatalogue.byTitle("Psychology"));
        student.addSubject(subjectCatalogue.byTitle("Economics"));
        cohort.add(student);
        student = new Student(9999389377L,"Akari Jasmine",
                "Nakamura",6,2,2008,"Blue");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Japanese"));
        student.addSubject(subjectCatalogue.byTitle("Business"));
        student.addSubject(subjectCatalogue.byTitle("Legal Studies"));
        student.addSubject(subjectCatalogue.byTitle("Economics"));
        cohort.add(student);
        student = new Student(9999364918L,"Clara Rosie",
                "Foster",19,11,2007,"Green");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Food and Nutrition"));
        student.addSubject(subjectCatalogue.byTitle("Modern History"));
        student.addSubject(subjectCatalogue.byTitle("Physical Education"));
        student.addSubject(subjectCatalogue.byTitle("Geography"));
        cohort.add(student);
        student = new Student(9999658761L,"Lily Quinn",
                "Henderson",2,10,2007,"Red");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Food and Nutrition"));
        student.addSubject(subjectCatalogue.byTitle("Modern History"));
        student.addSubject(subjectCatalogue.byTitle("Physical Education"));
        student.addSubject(subjectCatalogue.byTitle("Geography"));
        cohort.add(student);
        student = new Student(9999581170L,"Elsie Freya",
                "Sanders",27,11,2007,"White");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Biology"));
        student.addSubject(subjectCatalogue.byTitle("Physics"));
        student.addSubject(subjectCatalogue.byTitle("Chemistry"));
        student.addSubject(subjectCatalogue.byTitle("Geography"));
        cohort.add(student);
        student = new Student(9999647815L,"Georgia Imogen",
                "Knight",4,8,2007,"Yellow");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Biology"));
        student.addSubject(subjectCatalogue.byTitle("Physics"));
        student.addSubject(subjectCatalogue.byTitle("Chemistry"));
        student.addSubject(subjectCatalogue.byTitle("English and Literature Extension"));
        cohort.add(student);
        student = new Student(9999414858L,"Clara Sadie",
                "Mitchell",7,7,2007,"Blue");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Psychology"));
        student.addSubject(subjectCatalogue.byTitle("Biology"));
        student.addSubject(subjectCatalogue.byTitle("Chemistry"));
        student.addSubject(subjectCatalogue.byTitle("Geography"));
        cohort.add(student);
        student = new Student(9999067551L,"Eleanor Matilda",
                "Webb",12,4,2008,"Green");
        student.addSubject(subjectCatalogue.byTitle("English"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Visual Art"));
        student.addSubject(subjectCatalogue.byTitle("Music"));
        student.addSubject(subjectCatalogue.byTitle("Psychology"));
        student.addSubject(subjectCatalogue.byTitle("Drama"));
        cohort.add(student);
        student = new Student(9999021692L,"Piper Bonnie",
                "Stone",17,9,2007,"Red");
        student.addSubject(subjectCatalogue.byTitle("Literature"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Visual Art"));
        student.addSubject(subjectCatalogue.byTitle("Music"));
        student.addSubject(subjectCatalogue.byTitle("Psychology"));
        student.addSubject(subjectCatalogue.byTitle("Drama"));
        cohort.add(student);
        student = new Student(9999783558L,"Harper Addison",
                "Porter",3,7,2007,"White");
        student.addSubject(subjectCatalogue.byTitle("Literature"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Visual Art"));
        student.addSubject(subjectCatalogue.byTitle("Music"));
        student.addSubject(subjectCatalogue.byTitle("Psychology"));
        student.addSubject(subjectCatalogue.byTitle("Design"));
        cohort.add(student);
        student = new Student(9999200725L,"Matilda Phoebe",
                "Sharp",18,2,2008,"Yellow");
        student.addSubject(subjectCatalogue.byTitle("Literature"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Visual Art"));
        student.addSubject(subjectCatalogue.byTitle("Music"));
        student.addSubject(subjectCatalogue.byTitle("Psychology"));
        student.addSubject(subjectCatalogue.byTitle("Design"));
        cohort.add(student);
        student = new Student(9999725839L,"Phoebe Molly",
                "Gibson",20,8,2007,"Blue");
        student.addSubject(subjectCatalogue.byTitle("Literature"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Ancient History"));
        student.addSubject(subjectCatalogue.byTitle("Physics"));
        student.addSubject(subjectCatalogue.byTitle("Geography"));
        student.addSubject(subjectCatalogue.byTitle("Digital Solutions"));
        cohort.add(student);
        student = new Student(9999415696L,"Charlotte Paige",
                "Ellis",5,5,2008,"Green");
        student.addSubject(subjectCatalogue.byTitle("Literature"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Ancient History"));
        student.addSubject(subjectCatalogue.byTitle("Physics"));
        student.addSubject(subjectCatalogue.byTitle("Geography"));
        student.addSubject(subjectCatalogue.byTitle("Digital Solutions"));
        cohort.add(student);
        student = new Student(9999688978L,"Paige Rosie",
                "Collins",7,11,2007,"Red");
        student.addSubject(subjectCatalogue.byTitle("Literature"));
        student.addSubject(subjectCatalogue.byTitle("General Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Biology"));
        student.addSubject(subjectCatalogue.byTitle("Physics"));
        student.addSubject(subjectCatalogue.byTitle("Geography"));
        student.addSubject(subjectCatalogue.byTitle("Digital Solutions"));
        cohort.add(student);
        student = new Student(9999678029L,"Molly Quinn",
                "Pearce",6,6,2008,"White");
        student.addSubject(subjectCatalogue.byTitle("Literature"));
        student.addSubject(subjectCatalogue.byTitle("Mathematical Methods"));
        student.addSubject(subjectCatalogue.byTitle("Engineering"));
        student.addSubject(subjectCatalogue.byTitle("Physics"));
        student.addSubject(subjectCatalogue.byTitle("Geography"));
        student.addSubject(subjectCatalogue.byTitle("Digital Solutions"));
        cohort.add(student);
        student = new Student(9999152357L,"Rosie Maeve",
                "Wells",6,6,2008,"Yellow");
        student.addSubject(subjectCatalogue.byTitle("Literature"));
        student.addSubject(subjectCatalogue.byTitle("Mathematical Methods"));
        student.addSubject(subjectCatalogue.byTitle("Engineering"));
        student.addSubject(subjectCatalogue.byTitle("Chemistry"));
        student.addSubject(subjectCatalogue.byTitle("Specialist Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("English and Literature Extension"));
        cohort.add(student);
        student = new Student(9999827434L,"Akane Eleanor",
                "Tendo",3,11,2007,"Blue");
        student.addSubject(subjectCatalogue.byTitle("Literature"));
        student.addSubject(subjectCatalogue.byTitle("Mathematical Methods"));
        student.addSubject(subjectCatalogue.byTitle("Japanese"));
        student.addSubject(subjectCatalogue.byTitle("Chemistry"));
        student.addSubject(subjectCatalogue.byTitle("Specialist Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Physics"));
        cohort.add(student);
        student = new Student(9999332370L,"Mei Sophia",
                "Zhang",7,7,2007,"Green");
        student.addSubject(subjectCatalogue.byTitle("Literature"));
        student.addSubject(subjectCatalogue.byTitle("Mathematical Methods"));
        student.addSubject(subjectCatalogue.byTitle("Engineering"));
        student.addSubject(subjectCatalogue.byTitle("Chemistry"));
        student.addSubject(subjectCatalogue.byTitle("Specialist Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Physics"));
        cohort.add(student);
        student = new Student(9999555688L,"Freya Harper",
                "Fraser",25,5,2008,"Red");
        student.addSubject(subjectCatalogue.byTitle("Literature"));
        student.addSubject(subjectCatalogue.byTitle("Mathematical Methods"));
        student.addSubject(subjectCatalogue.byTitle("Engineering"));
        student.addSubject(subjectCatalogue.byTitle("Ancient History"));
        student.addSubject(subjectCatalogue.byTitle("Biology"));
        student.addSubject(subjectCatalogue.byTitle("Physics"));
        cohort.add(student);
        student = new Student(9999416656L,"Ivy Matilda",
                "Walsh-Smith",13,5,2008,"White");
        student.addSubject(subjectCatalogue.byTitle("Literature"));
        student.addSubject(subjectCatalogue.byTitle("Mathematical Methods"));
        student.addSubject(subjectCatalogue.byTitle("Engineering"));
        student.addSubject(subjectCatalogue.byTitle("Chemistry"));
        student.addSubject(subjectCatalogue.byTitle("Biology"));
        student.addSubject(subjectCatalogue.byTitle("Physics"));
        cohort.add(student);
        student = new Student(9999025092L,"Zofia Emilia",
                "Gollschewsky",1,1,2008,"Yellow");
        student.addSubject(subjectCatalogue.byTitle("Literature"));
        student.addSubject(subjectCatalogue.byTitle("Mathematical Methods"));
        student.addSubject(subjectCatalogue.byTitle("Engineering"));
        student.addSubject(subjectCatalogue.byTitle("Chemistry"));
        student.addSubject(subjectCatalogue.byTitle("Biology"));
        student.addSubject(subjectCatalogue.byTitle("Physics"));
        cohort.add(student);
        student = new Student(9999438575L,"Ling-Ling",
                "Chen",8,12,2007,"Blue");
        student.addSubject(subjectCatalogue.byTitle("Literature"));
        student.addSubject(subjectCatalogue.byTitle("Mathematical Methods"));
        student.addSubject(subjectCatalogue.byTitle("Engineering"));
        student.addSubject(subjectCatalogue.byTitle("Chemistry"));
        student.addSubject(subjectCatalogue.byTitle("Biology"));
        student.addSubject(subjectCatalogue.byTitle("Physics"));
        cohort.add(student);
        student = new Student(9999621947L,"Luna Isabelle",
                "Grant",8,12,2007,"Green");
        student.addSubject(subjectCatalogue.byTitle("Literature"));
        student.addSubject(subjectCatalogue.byTitle("Mathematical Methods"));
        student.addSubject(subjectCatalogue.byTitle("Engineering"));
        student.addSubject(subjectCatalogue.byTitle("Chemistry"));
        student.addSubject(subjectCatalogue.byTitle("Biology"));
        student.addSubject(subjectCatalogue.byTitle("Physics"));
        cohort.add(student);
        student = new Student(9999772660L,"Ava Chloe",
                "Richards",25,5,2008,"Red");
        student.addSubject(subjectCatalogue.byTitle("Literature"));
        student.addSubject(subjectCatalogue.byTitle("Mathematical Methods"));
        student.addSubject(subjectCatalogue.byTitle("Engineering"));
        student.addSubject(subjectCatalogue.byTitle("Chemistry"));
        student.addSubject(subjectCatalogue.byTitle("Biology"));
        student.addSubject(subjectCatalogue.byTitle("Physics"));
        cohort.add(student);
        student = new Student(9999135972L,"Sienna Violet",
                "Harper",1,1,2008,"White");
        student.addSubject(subjectCatalogue.byTitle("Literature"));
        student.addSubject(subjectCatalogue.byTitle("Mathematical Methods"));
        student.addSubject(subjectCatalogue.byTitle("Engineering"));
        student.addSubject(subjectCatalogue.byTitle("Physics"));
        student.addSubject(subjectCatalogue.byTitle("Specialist Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Chemistry"));
        cohort.add(student);
        student = new Student(9999119404L,"Alina Jasmine",
                "Reid",9,5,2008,"Yellow");
        student.addSubject(subjectCatalogue.byTitle("Literature"));
        student.addSubject(subjectCatalogue.byTitle("Mathematical Methods"));
        student.addSubject(subjectCatalogue.byTitle("Engineering"));
        student.addSubject(subjectCatalogue.byTitle("Physics"));
        student.addSubject(subjectCatalogue.byTitle("Specialist Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Chemistry"));
        cohort.add(student);
        student = new Student(9999353258L,"Eliza Georgia",
                "Black",7,3,2008,"Blue");
        student.addSubject(subjectCatalogue.byTitle("Literature"));
        student.addSubject(subjectCatalogue.byTitle("Mathematical Methods"));
        student.addSubject(subjectCatalogue.byTitle("Biology"));
        student.addSubject(subjectCatalogue.byTitle("Chemistry"));
        student.addSubject(subjectCatalogue.byTitle("Specialist Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Physics"));
        cohort.add(student);
        student = new Student(9999225349L,"Hana Charlotte",
                "Nakamura",2,2,2008,"Green");
        student.addSubject(subjectCatalogue.byTitle("Literature"));
        student.addSubject(subjectCatalogue.byTitle("Mathematical Methods"));
        student.addSubject(subjectCatalogue.byTitle("Japanese"));
        student.addSubject(subjectCatalogue.byTitle("Chemistry"));
        student.addSubject(subjectCatalogue.byTitle("Specialist Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Physics"));
        cohort.add(student);
        student = new Student(9999298457L,"Layla Paige",
                "Sterling",2,6,2008,"Red");
        student.addSubject(subjectCatalogue.byTitle("Literature"));
        student.addSubject(subjectCatalogue.byTitle("Mathematical Methods"));
        student.addSubject(subjectCatalogue.byTitle("Biology"));
        student.addSubject(subjectCatalogue.byTitle("Chemistry"));
        student.addSubject(subjectCatalogue.byTitle("Specialist Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Physics"));
        cohort.add(student);
        student = new Student(9999253083L,"Aria Willow",
                "Clarke",16,4,2008,"White");
        student.addSubject(subjectCatalogue.byTitle("Literature"));
        student.addSubject(subjectCatalogue.byTitle("Mathematical Methods"));
        student.addSubject(subjectCatalogue.byTitle("Biology"));
        student.addSubject(subjectCatalogue.byTitle("Chemistry"));
        student.addSubject(subjectCatalogue.byTitle("Specialist Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Physics"));
        cohort.add(student);
        student = new Student(9999785722L,"Mai",
                "Cheng",11,11,2007,"Yellow");
        student.addSubject(subjectCatalogue.byTitle("Literature"));
        student.addSubject(subjectCatalogue.byTitle("Mathematical Methods"));
        student.addSubject(subjectCatalogue.byTitle("Biology"));
        student.addSubject(subjectCatalogue.byTitle("Chemistry"));
        student.addSubject(subjectCatalogue.byTitle("Specialist Mathematics"));
        student.addSubject(subjectCatalogue.byTitle("Digital Solutions"));
        cohort.add(student);
    }

    /**
     * Load up the current set of Year 12 Exams.
     */
    private void populateExams() {
        Exam exam = new Exam(subjectCatalogue.byTitle("English"),
                Exam.ExamType.INTERNAL,
                '3', 10, 3, 2025, 8, 30);
        exams.add(exam);
        exam = new Exam(subjectCatalogue.byTitle("Literature"),
                Exam.ExamType.INTERNAL,
                '3', 10, 3, 2025, 12, 30);
        exams.add(exam);
        exam = new Exam(subjectCatalogue.byTitle("Essential English"),
                Exam.ExamType.INTERNAL,
                '3', 10, 3, 2025, 12, 30);
        exams.add(exam);
        exam = new Exam(subjectCatalogue.byTitle("General Mathematics"),
                Exam.ExamType.INTERNAL,
                '3', 11, 3, 2025, 8, 30);
        exams.add(exam);
        exam = new Exam(subjectCatalogue.byTitle("Mathematical Methods"),
                Exam.ExamType.INTERNAL, '1', "Technology Free",
                '3', 11, 3, 2025, 12, 30);
        exams.add(exam);
        exam = new Exam(subjectCatalogue.byTitle("Mathematical Methods"),
                Exam.ExamType.INTERNAL, '2', "Technology Enabled",
                '3', 12, 3, 2025, 8, 30);
        exams.add(exam);
        exam = new Exam(subjectCatalogue.byTitle("Specialist Mathematics"),
                Exam.ExamType.INTERNAL, '1', "Technology Free",
                '3', 12, 3, 2025, 12, 30);
        exams.add(exam);
        exam = new Exam(subjectCatalogue.byTitle("Specialist Mathematics"),
                Exam.ExamType.INTERNAL, '2', "Technology Enabled",
                '3', 13, 3, 2025, 8, 30);
        exams.add(exam);
        exam = new Exam(subjectCatalogue.byTitle("Physics"),
                Exam.ExamType.INTERNAL,
                '3', 13, 3, 2025, 12, 30);
        exams.add(exam);
        exam = new Exam(subjectCatalogue.byTitle("Chemistry"),
                Exam.ExamType.INTERNAL,
                '3', 14, 3, 2025, 8, 30);
        exams.add(exam);
        exam = new Exam(subjectCatalogue.byTitle("Biology"),
                Exam.ExamType.INTERNAL,
                '3', 14, 3, 2025, 12, 30);
        exams.add(exam);
        exam = new Exam(subjectCatalogue.byTitle("Visual Art"),
                Exam.ExamType.INTERNAL,
                '3', 13, 3, 2025, 12, 30);
        exams.add(exam);
        exam = new Exam(subjectCatalogue.byTitle("Business"),
                Exam.ExamType.INTERNAL,
                '3', 14, 3, 2025, 8, 30);
        exams.add(exam);
        exam = new Exam(subjectCatalogue.byTitle("Accounting"),
                Exam.ExamType.INTERNAL,
                '3', 14, 3, 2025, 12, 30);
        exams.add(exam);
    }

    /**
     * Load up the current set of Rooms and Venues.
     */
    private void populateRooms() {
        Room room = new Room("R1");
        rooms.addRoom(room);
        Venue venue = new Venue("V1", 1, rooms, 5, 5, 25, false);
        venues.addVenue(venue);
        room = new Room("R2");
        rooms.addRoom(room);
        RoomList tmp = new RoomList();
        tmp.addRoom(room);
        venue = new Venue("V2", 1, tmp, 5, 5, 25, false);
        venues.addVenue(venue);
        room = new Room("R3");
        rooms.addRoom(room);
        tmp = new RoomList();
        tmp.addRoom(room);
        venue = new Venue("V3", 1, tmp, 5, 5, 25, false);
        venues.addVenue(venue);
        venue = new Venue("V1+V2+V3", 3, rooms, 5, 16, 80, false);
        venues.addVenue(venue);
        room = new Room("S101");
        rooms.addRoom(room);
        tmp = new RoomList();
        tmp.addRoom(room);
        venue = new Venue("W1", 1, tmp, 1, 5, 5, true);
        venues.addVenue(venue);
        room = new Room("S102");
        rooms.addRoom(room);
        tmp.addRoom(room);
        RoomList tmp2 = new RoomList();
        tmp2.addRoom(room);
        venue = new Venue("W2", 1, tmp2, 2, 5, 10, true);
        venues.addVenue(venue);
        venue = new Venue("W1+W2", 2, tmp, 3, 5, 15, true);
        venues.addVenue(venue);
    }

}
